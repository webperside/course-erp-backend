package com.webperside.courseerpbackend.services.teacher;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.models.mappers.UserEntityMapper;
import com.webperside.courseerpbackend.models.mybatis.role.Role;
import com.webperside.courseerpbackend.models.mybatis.teacher.Teacher;
import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.models.payload.teacher.TeacherPayload;
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
import static com.webperside.courseerpbackend.models.enums.response.ErrorResponseMessages.TEACHER_ALREADY_ADDED_TO_GROUP;
import static com.webperside.courseerpbackend.utils.CommonUtils.throwIf;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherBusinessServiceImpl implements TeacherBusinessService{

    final UserService userService;

    final TeacherService teacherService;

    final GroupService groupService;

    final RoleService roleService;

    final BCryptPasswordEncoder passwordEncoder;

    static final String PASSWORD = "123456789";


    @Override
    public void addTeacher(TeacherPayload teacherPayload) {
        throwIf(()->userService.checkByPhoneNumber(teacherPayload.getPhoneNumber()),
                BaseException.of(PHONE_NUMBER_ALREADY_EXIST));

        // todo: we will change ROLE
        Role defaultRole = roleService.getDefaultRole();

        User user = UserEntityMapper.INSTANCE.fromTeacherPayloadToUser(
                teacherPayload,
                //todo: change PASSWORD
                passwordEncoder.encode(PASSWORD),
                defaultRole.getId()
        );

        userService.insert(user);

        teacherService.insert(Teacher.builder().userId(user.getId()).build());
    }

    @Override
    public void addTeacherToGroup(long teacherId, long groupId) {
        teacherService.findById(teacherId);
        groupService.findById(groupId);

        throwIf(()->teacherService.checkTeacherAlreadyAddedToGroup(teacherId),
                BaseException.of(TEACHER_ALREADY_ADDED_TO_GROUP));
    }
}
