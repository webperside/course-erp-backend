package com.webperside.courseerpbackend.services.group;

import com.webperside.courseerpbackend.models.mybatis.group.Group;

import java.util.List;

public interface GroupService {

    List<Group> findAll();
    Group findById(Long id);
    void insert(Group group);
    void  update(Group group);
}
