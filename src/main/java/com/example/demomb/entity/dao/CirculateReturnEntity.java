package com.example.demomb.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * 退货记录表
 */
@ApiModel(value = "CirculateReturnEntity")
@TableName(value = "tz_returns")
@Data
public class CirculateReturnEntity implements Serializable {

    @ApiModelProperty(value = "主键 id", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商品名称")
    @NotBlank(message = "商品名称不能为空")
    @TableField(value = "product_name")
    private String productName;

    @ApiModelProperty(value = "商品条码/二维码")
    @NotBlank(message = "商品条码/二维码不能为空")
    @TableField(value = "bar_code")
    private String barCode;

    @ApiModelProperty(value = "批号")
    @NotBlank(message = "批号不能为空")
    @TableField(value = "batch")
    private String batch;

    @ApiModelProperty(value = "生产日期")
    @NotBlank(message = "生产日期不能为空")
    @TableField(value = "produced_date")
    private String producedDate;

    @ApiModelProperty(value = "生产企业统一社会信用代码")
    @NotNull(message = "生产企业统一社会信用代码字段必须存在")
    @TableField(value = "social_credit_unicode")
    private String socialCreditUnicode;

    @ApiModelProperty(value = "单位")
    @NotBlank(message = "单位不能为空")
    @TableField(value = "unit")
    private String unit;

    @ApiModelProperty(value = "退货数量")
    @NotBlank(message = "退货数量不能为空")
    @TableField(value = "return_num")
    private String returnNum;

    @ApiModelProperty(value = "经度")
    @NotNull(message = "经度字段必须存在")
    @TableField(value = "longitude")
    private String longitude;

    @ApiModelProperty(value = "纬度")
    @NotNull(message = "纬度字段必须存在")
    @TableField(value = "latitude")
    private String latitude;

    @ApiModelProperty(value = "台账所属公司统一社会信用代码")
    @NotBlank(message = "台账所属公司统一社会信用代码不能为空")
    @TableField(value = "from_company_code")
    private String fromCompanyCode;

    @ApiModelProperty(value = "所属平台")
    @NotBlank(message = "所属平台不能为空")
    @TableField(value = "from_platform")
    private String fromPlatform;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_at")
    private String createdAt;

    @ApiModelProperty(value = "最近一次修改时间")
    @TableField(value = "updated_at")
    private String updatedAt;


}
