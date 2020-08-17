package com.example.demomb.controller;

import com.example.demomb.controller.model.ResponseCode;
import com.example.demomb.controller.model.ResponseModel;
import com.example.demomb.entity.ValidableList;
import com.example.demomb.entity.dao.CirculateSupplyEntity;
import com.example.demomb.service.CirculateSupplyService;
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

@Api(tags = "CirculateSupply", description = "食品流通企业:进货记录")
@RestController
@RequestMapping("/v1/circulate/supply")
public class CirculateSupplyController extends BaseController {

    @Autowired
    CirculateSupplyService supplyService;

    @ApiOperation(value = "推送数据", notes = "", httpMethod = "POST")
    @PostMapping
    public ResponseModel add(@ApiParam(name = "circulateSupplyEntitys", value = "进货记录") @Valid @RequestBody ValidableList<CirculateSupplyEntity> circulateSupplyEntitys) {
        try {
            supplyService.saveBatch(circulateSupplyEntitys);
            return new ResponseModel(new Date().getTime(), null, ResponseCode._200, null);
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }

}
