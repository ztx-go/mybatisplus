package com.example.demomb.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 商品表
 */
@TableName(value = "lt_goods")
@Data
public class GoodEntity implements Serializable {

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "条形码/二维码")
    @TableField(value = "bar_code")
    private String barCode;

    @ApiModelProperty(value = "商品名称")
    @TableField(value = "goods_name")
    private String goodsName;

    @ApiModelProperty(value = "商品类型")
    @TableField(value = "goods_type")
    private String goodsType;

    @ApiModelProperty(value = "生产企业名称")
    @TableField(value = "seller_name")
    private String sellerName;

    @ApiModelProperty(value = "生产企业统一社会信用代码")
    @TableField(value = "social_credit_unicode")
    private String socialCreditUnicode;

    @ApiModelProperty(value = "保质期数值")
    @TableField(value = "expiry_date_num")
    private String expiryDateNum;

    @ApiModelProperty(value = "保质期单位")
    @TableField(value = "expiry_date_unit")
    private String expiryDateUnit;

    @ApiModelProperty(value = "规格")
    @TableField(value = "specification")
    private String specification;

    @ApiModelProperty(value = "最小销售单元")
    @TableField(value = "min_sales_unit")
    private String minSalesUnit;

    @ApiModelProperty(value = "商品类别")
    @TableField(value = "product_category_name")
    private String productCategoryName;

    @ApiModelProperty(value = "商标")
    @TableField(value = "trademark")
    private String trademark;

    @ApiModelProperty(value = "商品所属公司统一社会信用代码")
    @TableField(value = "from_company_code")
    private String fromCompanyCode;

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
