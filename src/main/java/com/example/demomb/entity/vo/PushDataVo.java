package com.example.demomb.entity.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "PushDataVo")
@Data
public class PushDataVo {
    @ApiModelProperty(value = "要推送的具体数据",example = "[{\"name\":\"aaa\",\"age\":\"12\"},{\"name\":\"bbb\",\"age\":\"22\"}]")
    private String info;
    @ApiModelProperty(value = "目录标识",example = "01")
    private String catalogid;
    @ApiModelProperty(value = "format")
    private String format;
    @ApiModelProperty(value = "身份认证码",example = "123456")
    private String verifyCode;
    @ApiModelProperty(value = "附件名称",example = "企业名称附件")
    private String fileName;
    @ApiModelProperty(value = "附件内容,byte数组")
    private byte[] fileContent;

}
