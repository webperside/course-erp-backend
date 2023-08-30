package com.webperside.courseerpbackend.services.security;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.models.dto.RefreshTokenDto;
import com.webperside.courseerpbackend.models.enums.branch.BranchStatus;
import com.webperside.courseerpbackend.models.mappers.CourseEntityMapper;
import com.webperside.courseerpbackend.models.mappers.UserEntityMapper;
import com.webperside.courseerpbackend.models.mybatis.branch.Branch;
import com.webperside.courseerpbackend.models.mybatis.course.Course;
import com.webperside.courseerpbackend.models.mybatis.employee.Employee;
import com.webperside.courseerpbackend.models.mybatis.role.Role;
import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.models.payload.auth.LoginPayload;
import com.webperside.courseerpbackend.models.payload.auth.RefreshTokenPayload;
import com.webperside.courseerpbackend.models.payload.auth.SignUpPayload;
import com.webperside.courseerpbackend.models.response.auth.LoginResponse;
import com.webperside.courseerpbackend.services.branch.BranchService;
import com.webperside.courseerpbackend.services.course.CourseService;
import com.webperside.courseerpbackend.services.employee.EmployeeService;
import com.webperside.courseerpbackend.services.role.RoleService;
import com.webperside.courseerpbackend.services.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.webperside.courseerpbackend.models.enums.response.ErrorResponseMessages.EMAIL_ALREADY_REGISTERED;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthBusinessServiceImpl implements AuthBusinessService {

    private final static String BRANCH_NAME_DEFAULT_PATTERN = "%s Default Branch";

    private final AuthenticationManager authenticationManager;
    private final AccessTokenManager accessTokenManager;
    private final RefreshTokenManager refreshTokenManager;
    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final CourseService courseService;
    private final BranchService branchService;
    private final EmployeeService employeeService;

    @Override
    public LoginResponse login(LoginPayload payload) {

        authenticate(payload);

        return prepareLoginResponse(payload.getEmail(), payload.isRememberMe());
    }

    @Override
    public LoginResponse refresh(RefreshTokenPayload payload) {
        return prepareLoginResponse(
                refreshTokenManager.getEmail(payload.getRefreshToken()),
                payload.isRememberMe()
        );
    }

    @Override
    public void logout() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("{} user logout succeed", userDetails.getUsername());
    }

    @Override
    public void signUp(SignUpPayload payload) {

        if (userService.checkByEmail(payload.getEmail())) {
            throw BaseException.of(EMAIL_ALREADY_REGISTERED);
        }

        Role defaultRole = roleService.getDefaultRole();

        // Stage 1: User insert
        User user = UserEntityMapper.INSTANCE.fromSignUpPayloadToUser(
                payload,
                passwordEncoder.encode(payload.getPassword()),
                defaultRole.getId()
        );
        userService.insert(user);

        // Stage 2: Course insert
        Course course = CourseEntityMapper.INSTANCE.fromSignUpPayload(payload);
        courseService.insert(course);

        // Stage 3: Default branch insert
        branchService.insert(populateDefaultBranchData(payload, course));

        // Stage 4: Employee insert
        employeeService.insert(Employee.builder().userId(user.getId()).build());

        /*
        1. course insert +
        2. default branch insert +
        3. employee insert - refactor +
        3.1 employee-branch relation +
        4. sending otp (email) +
        5. verification otp +
        6. login - if user is not confirmed, can't login system
         */

    }

    @Override
    public void setAuthentication(String email) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities())
        );
    }

    // private util methods

    private void authenticate(LoginPayload request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
        } catch (AuthenticationException e) {
            throw e.getCause() instanceof BaseException ?
                    (BaseException) e.getCause() :
                    BaseException.unexpected();
        }
    }

    private LoginResponse prepareLoginResponse(String email, boolean rememberMe) {
        User user = userService.getByEmail(email);

        return LoginResponse.builder()
                .accessToken(accessTokenManager.generate(user))
                .refreshToken(refreshTokenManager.generate(
                        RefreshTokenDto.builder()
                                .user(user)
                                .rememberMe(rememberMe)
                                .build()
                ))
                .build();
    }

    private Branch populateDefaultBranchData(SignUpPayload payload, Course course) {
        // TODO: customize field setters
        return Branch.builder()
                .name(BRANCH_NAME_DEFAULT_PATTERN.formatted(payload.getCourseName()))
                .status(BranchStatus.ACTIVE)
                .address(payload.getAddress())
                .courseId(course.getId())
                .build();
    }
}
