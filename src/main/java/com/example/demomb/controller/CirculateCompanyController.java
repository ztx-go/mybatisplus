package com.example.demomb.controller;

import com.example.demomb.controller.model.ResponseCode;
import com.example.demomb.controller.model.ResponseModel;
import com.example.demomb.entity.ValidableList;
import com.example.demomb.entity.dao.CirculateCompanyEntity;
import com.example.demomb.service.CirculateCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@Api(tags = "CirculateCompany", description = "食品流通企业:供货商信息和经销商信息")
@RestController
@RequestMapping("/v1/circulate/company")
public class CirculateCompanyController extends BaseController {

    @Autowired
    CirculateCompanyService companyService;

    @ApiOperation(value = "推送数据", notes = "", httpMethod = "POST")
    @PostMapping(value = "/pushData")
    public ResponseModel add(@ApiParam(name = "circulateCompanyEntitys", value = "供货商信息和经销商信息") @Valid @RequestBody ValidableList<CirculateCompanyEntity> circulateCompanyEntitys) {
        try {
            companyService.saveBatch(circulateCompanyEntitys);
            return new ResponseModel(new Date().getTime(), null, ResponseCode._200, null);
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }
}
