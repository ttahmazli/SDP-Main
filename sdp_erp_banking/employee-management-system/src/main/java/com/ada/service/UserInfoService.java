package com.ada.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ada.models.UserInfo;
import com.ada.repository.UserInfoRepository;

@Service(value = "userInfoService")
public class UserInfoService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Qualifier("userInfoRepository")
    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfo getUserInfo() {

        return this.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    public UserInfo findUserByEmail(String email) {
        return userInfoRepository.findByEmail(email);
    }

    public void saveUser(UserInfo userInfo) {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userInfo.setActive(false);
        userInfoRepository.save(userInfo);

    }

    public List<UserInfo> getUsers() {

        return userInfoRepository.findAllByOrderById();
    }

    public UserInfo getUserById(int id) {

        return userInfoRepository.findById(id);
    }

    public void deleteUser(int id) {
        userInfoRepository.delete(id);
    }

    public void blockUser(int id) {

        userInfoRepository.blockUser(id);
    }

    public void unBlockUser(int id) {

        userInfoRepository.unBlockUser(id);
    }
}
