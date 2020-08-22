package com.example.demomb.controller;

import com.example.demomb.controller.model.ResponseCode;
import com.example.demomb.controller.model.ResponseModel;
import com.example.demomb.entity.ValidableList;
import com.example.demomb.entity.dao.CirculateSupplyDetailEntity;
import com.example.demomb.service.CirculateSupplyDetailService;
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

@Api(tags = "CirculateSupplyDetail", description = "食品流通企业:进货商品明细")
@RestController
@RequestMapping("/v1/circulate/supply_detail")
public class CirculateSupplyDetailController extends BaseController {

    @Autowired
    CirculateSupplyDetailService supplyDetailService;

    @ApiOperation(value = "推送数据", notes = "", httpMethod = "POST")
    @PostMapping
    public ResponseModel add(@ApiParam(name = "circulateSupplyDetailEntitys", value = "进货商品明细") @Valid @RequestBody ValidableList<CirculateSupplyDetailEntity> circulateSupplyDetailEntitys) {
        try {
            supplyDetailService.saveBatch(circulateSupplyDetailEntitys);
            return new ResponseModel(new Date().getTime(), null, ResponseCode._200, null);
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }
}
