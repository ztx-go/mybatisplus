package com.example.demomb.controller;

import com.example.demomb.controller.model.ResponseCode;
import com.example.demomb.controller.model.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;

/**
 * 基础controller
 *
 */
public class BaseController {

  /**
   * 日志
   */
  private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

    protected ResponseModel buildHttpReslutForException(Exception e) {
        String errorMsg = "";
        if (e != null) {
            errorMsg = e.getMessage();
            LOG.error(errorMsg, e);
        }
        ResponseModel result =
                new ResponseModel(new Date().getTime(), null, ResponseCode._501, errorMsg);
        return result;
    }


}
