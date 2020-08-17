package com.example.demomb.service.internal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomb.entity.dao.CirculateSupplyEntity;
import com.example.demomb.mapper.CirculateSupplyMapper;
import com.example.demomb.service.CirculateSupplyService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CirculateSupplyServiceImpl extends ServiceImpl<CirculateSupplyMapper, CirculateSupplyEntity> implements CirculateSupplyService {

    @Autowired
    private CirculateSupplyMapper SupplyMapper;

    @Override
    public void create(JSONObject jsonObject) {
//json数组 info不需要判断是否为空，可能同步的内容就是空
        JSONArray jsonArray = jsonObject.getJSONArray("info");
        String info = jsonObject.getString("info");
        System.out.println(info);
//        List<CirculateCompanyEntity> companyEntities = JSON.parseArray(info, CirculateCompanyEntity.class);
//        System.out.println(companyEntities);
        List<CirculateSupplyEntity> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            Validate.notBlank(object.getString("supplyEntName"), "第" + i + "行：供货商名称--不能为空");
            Validate.notBlank(object.getString("stockDate"), "第" + i + "行：进货日期--不能为空");
            Validate.notBlank(object.getString("fromCompanyCode"), "第" + i + "行：台账所属公司统一社会信用代码--不能为空");
            Validate.notBlank(object.getString("fromPlatform"), "第" + i + "行：所属平台--不能为空");

            CirculateSupplyEntity supplyEntity = JSON.toJavaObject(object, CirculateSupplyEntity.class);
            list.add(supplyEntity);
        }
        saveBatch(list);
    }
}
