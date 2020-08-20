package com.example.demomb.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demomb.common.FileUtil;
import com.example.demomb.controller.model.ResponseCode;
import com.example.demomb.controller.model.ResponseModel;
import com.example.demomb.entity.ValidableList;
import com.example.demomb.entity.vo.PushDataVo;
import com.example.demomb.service.internal.CirculateCompanyServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

//@Api(value = "test controller")
//@Api(tags = "TEST", description = "TEST Control")
//@RestController
@RequestMapping("/v1/test")
public class TestController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    CirculateCompanyServiceImpl companyService;

    @ApiOperation(value = "createUser", notes = "createUser", httpMethod = "POST")
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ResponseModel createUser(@ApiParam(name = "userEntity", value = "userEntity的数据") @RequestBody @Valid ValidableList<UserEntity> userEntitys) {
        try {

            userService.create(userEntitys.get(0));

            return new ResponseModel(new Date().getTime(), null, ResponseCode._200, null);
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }

    }

    @ApiOperation(value = "新增用户", notes = "传 json, 数据放 body", httpMethod = "POST")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseModel test(@RequestBody JSONObject jsonObject) {
        try {
            System.out.println(jsonObject);

            //目录
            String catalogid = jsonObject.getString("Catalogid");
            Validate.notBlank(catalogid, "目录标识不能为空");

            //身份
            String verifyCode = jsonObject.getString("verifyCode");
            Validate.notBlank(verifyCode, "身份认证码不能为空");

            //文件
            String fileName = jsonObject.getString("fileName");
            if (StringUtils.isNotBlank(fileName)) {
                byte[] filContents = jsonObject.getBytes("filContent");
                File test = FileUtil.byte2File(filContents, "test", fileName);

                InputStream inputStream = new ByteArrayInputStream(filContents);
                // MultipartFile file = new MockMultipartFile("新文件名","原文件名",ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream);
                MultipartFile file = new MockMultipartFile("新文件名", "原文件名", "text/plain", inputStream);
                //有个问题，https://www.zhihu.com/question/53215827?sort=created
                //    问题是这个spring-test依赖只用于测试，项目打包后就不存在了，除非是没有maven，gradle的自由式打包

                //    https://www.cnblogs.com/youyouxiaosheng-lh/p/11026763.html,需要试验一下
                FileItemFactory factory = new DiskFileItemFactory(16, null);
                String textFieldName = "textField";
                FileItem item = factory.createItem(textFieldName, "text/plain", true, fileName);
                int bytesRead = 0;
                byte[] buffer = new byte[8192];
                try {
                    FileInputStream fis = new FileInputStream("savePath" + fileName);
                    OutputStream os = item.getOutputStream();
                    while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }
                    os.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                MultipartFile multipartFile = new CommonsMultipartFile(item);
                //    https://bbs.csdn.net/topics/320256753 需要额外导入两个包

            }
            companyService.create(jsonObject);

            return new ResponseModel(new Date().getTime(), null, ResponseCode._200, null);
        } catch (Exception e) {
            return this.buildHttpReslutForException(e);
        }
    }

    @ApiOperation(value = "推送数据", notes = "", httpMethod = "POST")
    @RequestMapping(value = "/pushData", method = RequestMethod.POST)
    public String pushData(@ApiParam(name = "info", value = "推送的数据") String info, @ApiParam(value = "catalogid") String catalogid,
                           @ApiParam(value = "format") String format, @ApiParam(value = "verifyCode") String verifyCode,
                           @ApiParam(value = "fileName") String[] fileName, @ApiParam(value = "fileContent") byte[] fileContent) {


        return "200";
    }

    @ApiOperation(value = "推送数据", notes = "", httpMethod = "POST")
    @RequestMapping(value = "/pushData2", method = RequestMethod.POST)
    public String pushData2(@ApiParam(name = "PushDataVo", value = "推送的数据") @RequestBody PushDataVo pushDataVo) {


        return "200";
    }
}
