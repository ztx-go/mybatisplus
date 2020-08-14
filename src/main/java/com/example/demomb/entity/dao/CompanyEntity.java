package com.example.demomb.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 企业信息表企业信息表
 */
@TableName(value = "lt_companies")
@Data
public class CompanyEntity implements Serializable {

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "企业名称")
    @TableField(value = "fst_ent_name")
    private String fstEntName;

    @ApiModelProperty(value = "统一社会信用代码")
    @TableField(value = "social_credit_unicode")
    private String socialCreditUnicode;

    @ApiModelProperty(value = "经营场所")
    @TableField(value = "dom")
    private String dom;

    @ApiModelProperty(value = "联系人")
    @TableField(value = "contacts_user")
    private String contactsUser;

    @ApiModelProperty(value = "联系电话")
    @TableField(value = "contacts_tel")
    private String contactsTel;

    @ApiModelProperty(value = "营业范围")
    @TableField(value = "op_scope")
    private String opScope;

    @ApiModelProperty(value = "经营起始时间")
    @TableField(value = "op_start_date")
    private String opStartDate;

    @ApiModelProperty(value = "经营终止时间")
    @TableField(value = "op_end_date")
    private String opEndDate;

    @ApiModelProperty(value = "省级行政区划")
    @TableField(value = "province")
    private String province;

    @ApiModelProperty(value = "市级行政区划")
    @TableField(value = "city")
    private String city;

    @ApiModelProperty(value = "区县级行政区划")
    @TableField(value = "district")
    private String district;

    @ApiModelProperty(value = "经营地点所属机构或所")
    @TableField(value = "institute")
    private String institute;

    @ApiModelProperty(value = "经营地点完整地址")
    @TableField(value = "full_address")
    private String fullAddress;

    @ApiModelProperty(value = "经度")
    @TableField(value = "longitude")
    private String longitude;

    @ApiModelProperty(value = "纬度")
    @TableField(value = "latitude")
    private String latitude;

    @ApiModelProperty(value = "企业类型")
    @TableField(value = "type")
    private String type;

    @ApiModelProperty(value = "主体所属批发市场统一社会信用代码")
    @TableField(value = "belong_market")
    private String belongMarket;

    @ApiModelProperty(value = "所属平台")
    @TableField(value = "from_platform")
    private String fromPlatform;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_at")
    private String createdAt;

    @ApiModelProperty(value = "最近一次修改时间")
    @TableField(value = "updated_at")
    private String updatedAt;

}
