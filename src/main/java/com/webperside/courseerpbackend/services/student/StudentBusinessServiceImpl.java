package com.webperside.courseerpbackend.services.student;

import com.webperside.courseerpbackend.exception.BaseException;
import static com.webperside.courseerpbackend.models.enums.response.ErrorResponseMessages.PHONE_NUMBER_ALREADY_EXIST;
import static com.webperside.courseerpbackend.models.enums.response.ErrorResponseMessages.STUDENT_ALREADY_ADDED_TO_GROUP;

import com.webperside.courseerpbackend.models.mappers.UserEntityMapper;
import com.webperside.courseerpbackend.models.mybatis.appConfigs.AppConfig;
import com.webperside.courseerpbackend.models.mybatis.group.Group;
import com.webperside.courseerpbackend.models.mybatis.role.Role;
import com.webperside.courseerpbackend.models.mybatis.student.Student;
import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.models.payload.student.StudentPayload;
import com.webperside.courseerpbackend.services.group.GroupService;
import com.webperside.courseerpbackend.services.role.RoleService;
import com.webperside.courseerpbackend.services.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentBusinessServiceImpl implements StudentBusinessService {
    private final UserService userService;
    private final StudentService studentService;
    private final GroupService groupService;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;
    private static final String PASSWORD = "123456789";


    //todo:Assign process for groups
    @Override
    public void addStudent(StudentPayload studentPayload) {

        if (userService.checkByPhoneNumber(studentPayload.getPhoneNumber())) {
            throw BaseException.of(PHONE_NUMBER_ALREADY_EXIST);
        }

        //todo: we will change ROLE
        Role defaultRole = roleService.getDefaultRole();

        User user = UserEntityMapper.INSTANCE.fromStudentPayloadToUser(
                studentPayload,
                //todo: we will change PASSWORD
                passwordEncoder.encode(PASSWORD),
                defaultRole.getId()
        );

        userService.insert(user);

        studentService.insert(Student.builder().userId(user.getId()).build());

    }

    @Override
    public void addStudentToGroup(long studentId, long groupId) {

        studentService.findById(studentId);
        groupService.findById(groupId);

        if(studentService.checkStudentAlreadyAddedToGroup(studentId)){
            throw BaseException.of(STUDENT_ALREADY_ADDED_TO_GROUP);
        }

        studentService.addStudentToGroup(studentId, groupId);
    }

}
