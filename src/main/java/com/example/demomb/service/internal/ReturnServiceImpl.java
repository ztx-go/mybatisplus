package com.example.demomb.service.internal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomb.entity.dao.HandleEntity;
import com.example.demomb.entity.dao.ReturnEntity;
import com.example.demomb.mapper.ReturnMapper;
import com.example.demomb.service.ReturnService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReturnServiceImpl extends ServiceImpl<ReturnMapper, ReturnEntity> implements ReturnService {

    @Autowired
    private ReturnMapper returnMapper;

    @Override
    public void create(JSONObject jsonObject) {
//json数组 info不需要判断是否为空，可能同步的内容就是空
        JSONArray jsonArray = jsonObject.getJSONArray("info");
        String info = jsonObject.getString("info");
        System.out.println(info);
//        List<CompanyEntity> companyEntities = JSON.parseArray(info, CompanyEntity.class);
//        System.out.println(companyEntities);
        List<ReturnEntity> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            Validate.notBlank(object.getString("productName"), "第" + i + "行：商品名称--不能为空");
            Validate.notBlank(object.getString("barCode"), "第" + i + "行：商品条码/二维码--不能为空");
            Validate.notBlank(object.getString("batch"), "第" + i + "行：批号--不能为空");
            Validate.notBlank(object.getString("producedDate"), "第" + i + "行：生产日期--不能为空");
            Validate.notBlank(object.getString("unit"), "第" + i + "行：单位--不能为空");
            Validate.notBlank(object.getString("returnNum"), "第" + i + "行：退货数量--不能为空");
            Validate.notBlank(object.getString("fromCompanyCode"), "第" + i + "行：台账所属公司统一社会信用代码--不能为空");
            Validate.notBlank(object.getString("fromPlatform"), "第" + i + "行：所属平台--不能为空");

            ReturnEntity returnEntity = JSON.toJavaObject(object, ReturnEntity.class);
            list.add(returnEntity);
        }

        saveBatch(list);
    }
}
