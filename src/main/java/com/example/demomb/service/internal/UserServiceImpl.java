package com.example.demomb.service.internal;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomb.entity.dao.UserEntity;
import com.example.demomb.mapper.UserMapper;
import com.example.demomb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public void create(UserEntity userEntity) {

        userMapper.insert(userEntity);

    }

    @Override
    public UserEntity findByUsername(String name) {

        UserEntity user = userMapper.selectByName(name);
        return user;
    }

    @Override
    public UserEntity findUserById(String id) {

        UserEntity user = userMapper.selectById(id);
        return user;
    }

    @Transactional
    @Override
    public void register(UserEntity userRegister) {
         userMapper.insert(userRegister);
    }
}
