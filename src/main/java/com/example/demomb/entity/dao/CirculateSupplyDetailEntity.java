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
 * 进货商品明细表
 */
@ApiModel(value = "CirculateSupplyDetailEntity")
@TableName(value = "tz_supplies_details")
@Data
public class CirculateSupplyDetailEntity implements Serializable {

    @ApiModelProperty(value = "主键 id", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "外键:tz_supplies表ID")
    @TableField(value = "supply_id")
    private String supply_id;

    @ApiModelProperty(value = "产品名称")
    @NotBlank(message = "产品名称不能为空")
    @TableField(value = "product_name")
    private String productName;

    @ApiModelProperty(value = "条码/二维码")
    @NotBlank(message = "条码/二维码不能为空")
    @TableField(value = "bar_code")
    private String barCode;

    @ApiModelProperty(value = "批号")
    @NotBlank(message = "批号不能为空")
    @TableField(value = "batch")
    private String batch;

    @ApiModelProperty(value = "进货数量")
    @NotBlank(message = "进货数量不能为空")
    @TableField(value = "stock_num")
    private String stockNum;

    @ApiModelProperty(value = "生产日期")
    @NotNull(message = "生产日期字段必须存在")
    @TableField(value = "produced_date")
    private String producedDate;

    @ApiModelProperty(value = "生产企业统一社会信用代码")
    @NotBlank(message = "生产企业统一社会信用代码不能为空")
    @TableField(value = "social_credit_unicode")
    private String socialCreditUnicode;

    @ApiModelProperty(value = "单位")
    @NotBlank(message = "单位不能为空")
    @TableField(value = "unit")
    private String unit;

    @ApiModelProperty(value = "检验检疫报告")
    @NotNull(message = "检验检疫报告字段必须存在")
    @TableField(value = "detection_records")
    private String detectionRecords;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_at")
    private String createdAt;

    @ApiModelProperty(value = "最近一次修改时间")
    @TableField(value = "updated_at")
    private String updatedAt;

}
