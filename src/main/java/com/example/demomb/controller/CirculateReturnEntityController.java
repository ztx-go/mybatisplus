package com.example.demomb.controller;

import com.example.demomb.controller.model.ResponseCode;
import com.example.demomb.controller.model.ResponseModel;
import com.example.demomb.entity.ValidableList;
import com.example.demomb.entity.dao.CirculateReturnEntity;
import com.example.demomb.service.CirculateReturnService;
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

@Api(tags = "CirculateReturn", description = "食品流通企业:退货记录")
@RestController
@RequestMapping("/v1/circulate/return")
public class CirculateReturnEntityController extends BaseController {

    @Autowired
    CirculateReturnService returnService;

    @ApiOperation(value = "推送数据", notes = "", httpMethod = "POST")
    @PostMapping(value = "/pushData")
    public ResponseModel add(@ApiParam(name = "sirculateReturnEntitys", value = "退货记录") @Valid @RequestBody ValidableList<CirculateReturnEntity> sirculateReturnEntitys) {
        try {
            returnService.saveBatch(sirculateReturnEntitys);
            return new ResponseModel(new Date().getTime(), null, ResponseCode._200, null);
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }


}
