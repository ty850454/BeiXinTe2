package com.bxtsy.web.controller;

import com.bxtsy.web.bean.HttpResult;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/file")
public class FIleController {


    @GetMapping("/imgToken")
    public HttpResult<?> getImgToken() {
        String accessKey = "xRIeqSg5Dpp4ngkuTiJbBnQEXryYWoEePd4XvI_X";
        String secretKey = "AkCKdsl8_OO-9Lm3U-kF2ZjvlXy6MSm9fdCPJD2f";
        String bucket = "ty850454-public";
        StringMap putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"code\": \"success\", \"date\": \"http://cdn.dreammakerteam.com/$(key)\"}");
        putPolicy.put("isPrefixalScope", 1);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket, "bxt/", 3600, putPolicy);
        return HttpResult.success(upToken);
    }

}
