package com.example.demomb.controller;

import com.example.demomb.controller.model.ResponseCode;
import com.example.demomb.controller.model.ResponseModel;
import com.example.demomb.entity.ValidableList;
import com.example.demomb.entity.dao.CirculateGoodEntity;
import com.example.demomb.service.CirculateGoodService;
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

@Api(tags = "CirculateGood", description = "食品流通企业:商品信息")
@RestController
@RequestMapping("/v1/circulate/good")
public class CirculateGoodController extends BaseController {

    @Autowired
    CirculateGoodService goodService;

    @ApiOperation(value = "推送数据", notes = "", httpMethod = "POST")
    @PostMapping
    public ResponseModel add(@ApiParam(name = "circulateGoodEntitys", value = "商品信息") @Valid @RequestBody ValidableList<CirculateGoodEntity> circulateGoodEntitys) {
        try {
            goodService.saveBatch(circulateGoodEntitys);
            return new ResponseModel(new Date().getTime(), null, ResponseCode._200, null);
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }
}
