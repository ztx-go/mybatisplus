package com.example.demomb.service.internal;

<<<<<<< HEAD
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomb.entity.dao.UserEntity;
=======
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
>>>>>>> origin/master
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

<<<<<<< HEAD
        UserEntity user = userMapper.selectByName(name);
        return user;
=======
//        UserEntity user = userMapper.selectByName(name);
        QueryWrapper<UserEntity> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("username", name);
        UserEntity userEntity = userMapper.selectOne(objectQueryWrapper);


        return userEntity;
>>>>>>> origin/master
    }

    @Override
    public UserEntity findUserById(String id) {

        UserEntity user = userMapper.selectById(id);
        return user;
    }

    @Transactional
    @Override
    public void register(UserEntity userRegister) {
<<<<<<< HEAD
         userMapper.insert(userRegister);
=======
        userMapper.insert(userRegister);
>>>>>>> origin/master
    }
}
