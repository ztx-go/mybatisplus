package com.example.demomb.service.internal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomb.entity.dao.CirculateCompanyEntity;
import com.example.demomb.mapper.CirculateCompanyMapper;
import com.example.demomb.service.CirculateCompanyService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CirculateCompanyServiceImpl extends ServiceImpl<CirculateCompanyMapper, CirculateCompanyEntity> implements CirculateCompanyService {

    @Autowired
    private CirculateCompanyMapper companyMapper;

    @Transactional
    @Override
    public void create(JSONObject jsonObject) {

        //json数组 info不需要判断是否为空，可能同步的内容就是空
        JSONArray jsonArray = jsonObject.getJSONArray("info");
        String info = jsonObject.getString("info");
        System.out.println(info);
//        List<CirculateCompanyEntity> companyEntities = JSON.parseArray(info, CirculateCompanyEntity.class);
//        System.out.println(companyEntities);
        List<CirculateCompanyEntity> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            Validate.notBlank(object.getString("fstEntName"), "第" + i + "行：企业名称--不能为空");
            Validate.notBlank(object.getString("socialCreditUnicode"), "第" + i + "行：统一社会信用代码--不能为空");
            Validate.notBlank(object.getString("dom"), "第" + i + "行：经营场所不能为空");
            Validate.notBlank(object.getString("contactsUser"), "第" + i + "行：联系人--不能为空");
            Validate.notBlank(object.getString("contactsTel"), "第" + i + "行：联系电话--不能为空");
            Validate.notBlank(object.getString("opScope"), "第" + i + "行：营业范围--不能为空");
            Validate.notBlank(object.getString("opStartDate"), "第" + i + "行：经营起始时间--不能为空");
            Validate.notBlank(object.getString("opEndDate"), "第" + i + "行：经营终止时间--不能为空");
            Validate.notBlank(object.getString("province"), "第" + i + "行：省级行政区划--不能为空");
            Validate.notBlank(object.getString("city"), "第" + i + "行：市级行政区划--不能为空");
            Validate.notBlank(object.getString("district"), "第" + i + "行：区县级行政区划--不能为空");
            Validate.notBlank(object.getString("institute"), "第" + i + "行：经营地点所属机构或所--不能为空");
            Validate.notBlank(object.getString("fullAddress"), "第" + i + "行：经营地点完整地址--不能为空");
            Validate.notBlank(object.getString("type"), "第" + i + "行：企业类型--不能为空");
            Validate.notBlank(object.getString("belongMarket"), "第" + i + "行：主体所属批发市场统一社会信用代码--不能为空");
            Validate.notBlank(object.getString("fromPlatform"), "第" + i + "行：所属平台--不能为空");

            CirculateCompanyEntity companyEntity = JSON.toJavaObject(object, CirculateCompanyEntity.class);
            list.add(companyEntity);
            System.out.println(companyEntity);
        }

        saveBatch(list);
    }

}
