package com.webperside.courseerpbackend.services.role;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.models.mybatis.role.Role;
import com.webperside.courseerpbackend.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService{

    private final static String OWNER = "OWNER";
    private final RoleRepository roleRepository;

    @Override
    public Role getDefaultRole() {
        return roleRepository.findByName(OWNER).orElseThrow(BaseException::unexpected);
    }
}
