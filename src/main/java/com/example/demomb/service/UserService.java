package com.example.demomb.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demomb.entity.dao.UserEntity;

public interface UserService extends IService<UserEntity> {

    UserEntity findByUsername(String name);

    void create(UserEntity userEntity);

    UserEntity findUserById(String id);

    void register(UserEntity userRegister);
}
