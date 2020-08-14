package com.example.demomb.service.internal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomb.entity.dao.CompanyEntity;
import com.example.demomb.mapper.CompanyMapper;
import com.example.demomb.service.CompanyService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, CompanyEntity> implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Transactional
    public void create(JSONObject jsonObject) {

        //目录
        String catalogid = jsonObject.getString("Catalogid");
        Validate.notBlank(catalogid, "目录标识不能为空");

        //身份
        String verifyCode = jsonObject.getString("verifyCode");
        Validate.notBlank(verifyCode, "身份认证码不能为空");

        //文件
        String fileName = jsonObject.getString("fileName");
        if (StringUtils.isNotBlank(fileName)) {
//            String fileContent = jsonObject.getString("fileContent");
            byte[] filContents = jsonObject.getBytes("filContent");

        }

        //json数组
        JSONArray jsonArray = jsonObject.getJSONArray("info");
        String info = jsonObject.getString("info");
        System.out.println(info);
//        List<CompanyEntity> companyEntities = JSON.parseArray(info, CompanyEntity.class);
//        System.out.println(companyEntities);
        List<CompanyEntity> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            String fstEntName = object.getString("fstEntName");
            Validate.notBlank(fstEntName, "企业名称");

            String socialCreditUnicode = object.getString("socialCreditUnicode");
            Validate.notBlank(socialCreditUnicode, "统一社会信用代码");
            String dom = object.getString("dom");
            Validate.notBlank(dom, "经营场所");
            String contactsUser = object.getString("contactsUser");
            Validate.notBlank(contactsUser, "联系人");
            String contactsTel = object.getString("contactsTel");
            Validate.notBlank(contactsTel, "联系电话");
            String opScope = object.getString("opScope");
            Validate.notBlank(opScope, "营业范围");
            String opStartDate = object.getString("opStartDate");
            Validate.notBlank(opStartDate, "经营起始时间");
            String opEndDate = object.getString("opEndDate");
            Validate.notBlank(opEndDate, "经营终止时间");
            String province = object.getString("province");
            Validate.notBlank(province, "省级行政区划");
            String city = object.getString("city");
            Validate.notBlank(city, "市级行政区划");
            String district = object.getString("district");
            Validate.notBlank(district, "区县级行政区划");
            String institute = object.getString("institute");
            Validate.notBlank(institute, "经营地点所属机构或所");
            String fullAddress = object.getString("fullAddress");
            Validate.notBlank(fullAddress, "经营地点完整地址");
            String type = object.getString("type");
            Validate.notBlank(type, "企业类型");
            String belongMarket = object.getString("belongMarket");
            Validate.notBlank(belongMarket, "主体所属批发市场统一社会信用代码");
            String fromPlatform = object.getString("fromPlatform");
            Validate.notBlank(fromPlatform, "所属平台");

            CompanyEntity companyEntity = JSON.toJavaObject(object, CompanyEntity.class);
            list.add(companyEntity);
            System.out.println(companyEntity);
        }

        saveBatch(list);
    }

}
