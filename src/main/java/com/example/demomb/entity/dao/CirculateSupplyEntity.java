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
 * 进货记录表
 */
@ApiModel(value = "CirculateSupplyEntity")
@TableName(value = "tz_supplies")
@Data
public class CirculateSupplyEntity implements Serializable {


    @ApiModelProperty(value = "主键 id", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "供货商名称", required = true)
    @NotBlank(message = "供货商名称不能为空")
    @TableField(value = "supply_ent_name")
    private String supplyEntName;

    @ApiModelProperty(value = "供货商统一社会信用代码")
    @NotNull(message = "供货商统一社会信用代码字段必须存在")
    @TableField(value = "supply_ent_code")
    private String supplyEntCode;

    @ApiModelProperty(value = "进货日期", required = true)
    @NotBlank(message = "进货日期不能为空")
    @TableField(value = "stock_date")
    private String stockDate;

    @ApiModelProperty(value = "经度")
    @NotBlank(message = "经度字段必须存在")
    @TableField(value = "longitude")
    private String longitude;

    @ApiModelProperty(value = "纬度")
    @NotNull(message = "纬度字段必须存在")
    @TableField(value = "latitude")
    private String latitude;

    @ApiModelProperty(value = "台账所属公司统一社会信用代码")
    @NotNull(message = "台账所属公司统一社会信用代码字段必须存在")
    @TableField(value = "from_company_code")
    private String fromCompanyCode;

    @ApiModelProperty(value = "所属平台", required = true)
    @NotBlank(message = "所属平台不能为空")
    @TableField(value = "from_platform")
    private String fromPlatform;

    @ApiModelProperty(value = "创建时间", hidden = true)
    @TableField(value = "created_at")
    private String createdAt;

    @ApiModelProperty(value = "最近一次修改时间", hidden = true)
    @TableField(value = "updated_at")
    private String updatedAt;


}
