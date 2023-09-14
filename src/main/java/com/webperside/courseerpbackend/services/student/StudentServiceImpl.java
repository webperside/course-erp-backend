package com.webperside.courseerpbackend.services.student;

import com.webperside.courseerpbackend.exception.BaseException;
import static com.webperside.courseerpbackend.models.enums.response.ErrorResponseMessages.EMAIL_ALREADY_REGISTERED;
import static com.webperside.courseerpbackend.models.enums.response.ErrorResponseMessages.PHONE_NUMBER_ALREADY_EXIST;
import com.webperside.courseerpbackend.models.mappers.CourseEntityMapper;
import com.webperside.courseerpbackend.models.mappers.StudentEntityMapper;
import com.webperside.courseerpbackend.models.mappers.UserEntityMapper;
import com.webperside.courseerpbackend.models.mybatis.course.Course;
import com.webperside.courseerpbackend.models.mybatis.role.Role;
import com.webperside.courseerpbackend.models.mybatis.student.Student;
import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.models.payload.student.StudentPayload;
import com.webperside.courseerpbackend.repository.StudentRepository;
import com.webperside.courseerpbackend.services.role.RoleService;
import com.webperside.courseerpbackend.services.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final UserService userService;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;


    private static final String PASSWORD ="123456789";


    @Override
    public void insert(Student student) {
        studentRepository.insert(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> BaseException.notFound(Student.class.getSimpleName(), "student", String.valueOf(id))
        );
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }


//todo:Assign process for groups
    @Override
    public void addStudent(StudentPayload studentPayload){

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

        Long userId = user.getId();

        Student student = StudentEntityMapper.INSTANCE.studentDtoToStudent(userId);
        studentRepository.insert(student);

    }
}
