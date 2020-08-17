package com.example.demomb.service.internal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomb.entity.dao.CirculateHandleEntity;
import com.example.demomb.mapper.CirculateHandleMapper;
import com.example.demomb.service.CirculateHandleService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CirculateHandleServiceImpl extends ServiceImpl<CirculateHandleMapper, CirculateHandleEntity> implements CirculateHandleService {

    @Autowired
    private CirculateHandleMapper handleMapper;

    @Override
    public void create(JSONObject jsonObject) {
        //json数组 info不需要判断是否为空，可能同步的内容就是空
        JSONArray jsonArray = jsonObject.getJSONArray("info");
        String info = jsonObject.getString("info");
        System.out.println(info);
//        List<CirculateCompanyEntity> companyEntities = JSON.parseArray(info, CirculateCompanyEntity.class);
//        System.out.println(companyEntities);
        List<CirculateHandleEntity> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            Validate.notBlank(object.getString("productName"), "第" + i + "行：商品名称--不能为空");
            Validate.notBlank(object.getString("barCode"), "第" + i + "行：商品条码/二维码--不能为空");
            Validate.notBlank(object.getString("batch"), "第" + i + "行：批号--不能为空");
            Validate.notBlank(object.getString("producedDate"), "第" + i + "行：生产日期--不能为空");
            Validate.notBlank(object.getString("unit"), "第" + i + "行：单位--不能为空");
            Validate.notBlank(object.getString("returnNum"), "第" + i + "行：处理数量--不能为空");
            Validate.notBlank(object.getString("handleType"), "第" + i + "行：处理类型--不能为空");
            Validate.notBlank(object.getString("fromPlatform"), "第" + i + "行：所属平台--不能为空");

            CirculateHandleEntity handleEntity = JSON.toJavaObject(object, CirculateHandleEntity.class);
            list.add(handleEntity);
        }
        saveBatch(list);
    }
}
