package com.webperside.courseerpbackend.services.student;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.exception.ExceptionBuilder;
import com.webperside.courseerpbackend.models.mappers.UserEntityMapper;
import com.webperside.courseerpbackend.models.mybatis.role.Role;
import com.webperside.courseerpbackend.models.mybatis.student.Student;
import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.models.payload.student.StudentPayload;
import com.webperside.courseerpbackend.services.group.GroupService;
import com.webperside.courseerpbackend.services.role.RoleService;
import com.webperside.courseerpbackend.services.user.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.webperside.courseerpbackend.models.enums.response.ErrorResponseMessages.PHONE_NUMBER_ALREADY_EXIST;
import static com.webperside.courseerpbackend.models.enums.response.ErrorResponseMessages.STUDENT_ALREADY_ADDED_TO_GROUP;
import static com.webperside.courseerpbackend.utils.CommonUtils.throwIf;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentBusinessServiceImpl implements StudentBusinessService {
    final UserService userService;
    final StudentService studentService;
    final GroupService groupService;
    final RoleService roleService;
    final BCryptPasswordEncoder passwordEncoder;
    static final String PASSWORD = "123456789";


    //todo:Assign process for groups
    @Override
    public void addStudent(StudentPayload studentPayload) {

        throwIf(() -> userService.checkByPhoneNumber(studentPayload.getPhoneNumber()), ExceptionBuilder.of(PHONE_NUMBER_ALREADY_EXIST));

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

        throwIf(() -> studentService.checkStudentAlreadyAddedToGroup(studentId), ExceptionBuilder.of(STUDENT_ALREADY_ADDED_TO_GROUP));

        studentService.addStudentToGroup(studentId, groupId);
    }

}
