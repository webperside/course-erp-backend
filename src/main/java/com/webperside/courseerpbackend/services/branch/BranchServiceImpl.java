package com.webperside.courseerpbackend.services.branch;

import com.webperside.courseerpbackend.models.mybatis.branch.Branch;
import com.webperside.courseerpbackend.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    @Override
    public void insert(Branch branch) {
        branchRepository.insert(branch);
    }
}
