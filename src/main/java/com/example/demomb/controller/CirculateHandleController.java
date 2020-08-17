package com.example.demomb.controller;

import com.example.demomb.controller.model.ResponseCode;
import com.example.demomb.controller.model.ResponseModel;
import com.example.demomb.entity.ValidableList;
import com.example.demomb.entity.dao.CirculateHandleEntity;
import com.example.demomb.service.CirculateHandleService;
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

@Api(tags = "CirculateHandle", description = "食品流通企业:商品处理台账信息")
@RestController
@RequestMapping("/v1/circulate/handle")
public class CirculateHandleController extends BaseController {

    @Autowired
    CirculateHandleService handleService;

    @ApiOperation(value = "推送数据", notes = "", httpMethod = "POST")
    @PostMapping(value = "/pushData")
    public ResponseModel add(@ApiParam(name = "circulateHandleEntitys", value = "商品处理台账信息") @Valid @RequestBody ValidableList<CirculateHandleEntity> circulateHandleEntitys) {
        try {
            handleService.saveBatch(circulateHandleEntitys);
            return new ResponseModel(new Date().getTime(), null, ResponseCode._200, null);
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }
}
