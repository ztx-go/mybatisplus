package com.example.demomb.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demomb.controller.model.ResponseCode;
import com.example.demomb.controller.model.ResponseModel;
import com.example.demomb.service.internal.CompanyServiceImpl;
import com.example.demomb.service.internal.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
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

            //目录
            String catalogid = jsonObject.getString("Catalogid");
            Validate.notBlank(catalogid, "目录标识不能为空");

            //身份
            String verifyCode = jsonObject.getString("verifyCode");
            Validate.notBlank(verifyCode, "身份认证码不能为空");

            //文件
            String fileName = jsonObject.getString("fileName");
            if (StringUtils.isNotBlank(fileName)) {
                byte[] filContents = jsonObject.getBytes("filContent");

            }
            companyService.create(jsonObject);

            return new ResponseModel(new Date().getTime(), null, ResponseCode._200, null);
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }
}
