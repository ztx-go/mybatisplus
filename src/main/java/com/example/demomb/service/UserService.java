package com.example.demomb.service;

import com.example.demomb.entity.dao.UserEntity;
import com.example.demomb.mapper.UserMapper;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void create() {

        UserEntity userEntity = new UserEntity();
        userEntity.setName("test");
        userEntity.setAge("11");
        userMapper.insert(userEntity);
        Validate.notBlank(userEntity.getName(), "名字不能为空");
//        throw new IllegalArgumentException("ddd");

    }

}
