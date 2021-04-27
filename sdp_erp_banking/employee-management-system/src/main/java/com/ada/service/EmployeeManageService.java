package com.ada.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ada.models.LeaveDetails;
import com.ada.repository.EmployeeManageNativeSqlRepo;
import com.ada.repository.EmployeeManageRepository;

@Service(value = "leaveManageService")
public class EmployeeManageService {

    @Qualifier("leaveManageRepository")
    @Autowired
    private EmployeeManageRepository employeeManageRepository;

    @Autowired
    private EmployeeManageNativeSqlRepo leaveManageNativeRepo;

    @SuppressWarnings("deprecation")
    public void applyLeave(LeaveDetails leaveDetails) {

        int duration = leaveDetails.getToDate().getDate() - leaveDetails.getFromDate().getDate();
        leaveDetails.setDuration(duration + 1);
        leaveDetails.setActive(true);
        employeeManageRepository.save(leaveDetails);
    }

    public List<LeaveDetails> getAllLeaves() {

        return employeeManageRepository.findAll();
    }

    public List<LeaveDetails> getAllActiveLeaves() {

        return employeeManageRepository.getAllActiveLeaves();
    }

    public void updateLeaveDetails(LeaveDetails leaveDetails) {

        employeeManageRepository.save(leaveDetails);

    }

    public LeaveDetails getLeaveDetailsOnId(int id) {

        return employeeManageRepository.findOne(id);
    }

    public List<LeaveDetails> getAllLeavesOfUser(String username) {

        return employeeManageRepository.getAllLeavesOfUser(username);

    }

    public List<LeaveDetails> getAllLeavesOnStatus(boolean pending, boolean accepted, boolean rejected) {

        StringBuffer whereQuery = new StringBuffer();
        if (pending)
            whereQuery.append("active=true or ");
        if (accepted)
            whereQuery.append("(active=false and accept_reject_flag=true) or ");
        if (rejected)
            whereQuery.append("(active=false and accept_reject_flag=false) or ");

        whereQuery.append(" 1=0");

        return leaveManageNativeRepo.getAllLeavesOnStatus(whereQuery);
    }
}
