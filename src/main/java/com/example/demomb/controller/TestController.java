package com.example.demomb.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demomb.controller.model.ResponseCode;
import com.example.demomb.controller.model.ResponseModel;
import com.example.demomb.service.CompanyServiceImpl;
import com.example.demomb.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Api(value = "test controller")
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    CompanyServiceImpl companyService;

    @ApiOperation(value = "test", notes = "test")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseModel test(@RequestBody JSONObject jsonObject) {
        try {
            System.out.println(jsonObject);

            companyService.create(jsonObject);

            return new ResponseModel(new Date().getTime(), null, ResponseCode._200, null);
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }
}
