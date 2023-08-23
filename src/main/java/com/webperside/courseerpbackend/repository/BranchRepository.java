package com.webperside.courseerpbackend.repository;

import com.webperside.courseerpbackend.models.mybatis.branch.Branch;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BranchRepository {

    void insert(Branch branch);

}
