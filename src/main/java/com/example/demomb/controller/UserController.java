package com.example.demomb.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demomb.annotation.UserLoginToken;
import com.example.demomb.common.exception.TokenException;
import com.example.demomb.common.utils.PasswordUtils;
import com.example.demomb.controller.model.ResponseCode;
import com.example.demomb.controller.model.ResponseModel;
import com.example.demomb.entity.dao.UserEntity;
import com.example.demomb.service.internal.TokenServiceImpl;
import com.example.demomb.service.internal.UserServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/v1/user")
public class UserController extends BaseController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    TokenServiceImpl tockenService;


    @PostMapping(value = "/login")
    public ResponseModel login(@Valid @RequestBody UserEntity user) {
        try {
            JSONObject jsonObject = new JSONObject();
            UserEntity userForBase = userService.findByUsername(user.getUsername());
            if (userForBase == null) {
                return this.buildHttpReslutForException(new TokenException("登录失败,用户不存在"));
            } else {
                if (!PasswordUtils.isValidPassword(user.getPassword(), userForBase.getPassword(), userForBase.getPwdSalt())) {
                    return this.buildHttpReslutForException(new TokenException("登录失败,密码错误"));
                } else {
                    String token = tockenService.getToken(userForBase);
                    jsonObject.put("token", token);
                    return new ResponseModel(new Date().getTime(), jsonObject, ResponseCode._200, null);
                }
            }
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }


    @PostMapping(value = "/register")
    public ResponseModel register(@Valid @RequestBody UserEntity user) {
        try {

            UserEntity userForBase = userService.findByUsername(user.getUsername());
            if (userForBase == null) {
                UserEntity userRegister = new UserEntity();
                String salt = RandomStringUtils.randomAlphanumeric(24);
                userRegister.setPwdSalt(salt);
                String pwd = PasswordUtils.encodePassword(user.getPassword(), salt);
                boolean validPassword = PasswordUtils.isValidPassword(user.getPassword(), pwd, salt);
                System.out.println(validPassword);
                userRegister.setUsername(user.getUsername());
                userRegister.setPassword(pwd);
                userService.register(userRegister);
            }
            return new ResponseModel(new Date().getTime(), null, ResponseCode._200, null);

        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }

    @UserLoginToken
    @PostMapping(value = "/test")
    public ResponseModel test() {
        try {

            return new ResponseModel(new Date().getTime(), "200", ResponseCode._200, null);
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }

    @PostMapping(value = "/test2")
    public ResponseModel test2() {
        try {

            return new ResponseModel(new Date().getTime(), "200", ResponseCode._200, null);
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }
}
