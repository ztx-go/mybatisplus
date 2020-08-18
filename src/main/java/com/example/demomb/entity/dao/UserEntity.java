package com.example.demomb.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel(value = "UserEntity")
@TableName(value = "user")
@Data
public class UserEntity implements Serializable {

    @ApiModelProperty(hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    @TableField(value = "username")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码")
    @TableField(value = "password")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "盐值",hidden = true)
    @TableField(value = "pwdSalt")
    private String pwdSalt;
}
