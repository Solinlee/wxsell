package com.solin.wxsell.controller.tool;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

@Api("微信平台验证")
@RestController
public class wxController {

    @ApiOperation("微信公众平台验证接口")
    @GetMapping("wx")
    public String wx(@RequestParam String signature, Long timestamp, String nonce, String token,String echostr) {
        ArrayList<String> list = new ArrayList<>();
        String token1 = "XXXXXX";//微信公众里面自定义的token一致即可
        list.add(token1);
        list.add(timestamp + "");
        list.add(nonce);
        Collections.sort(list);
        String mySignature = DigestUtils.sha1DigestAsHex(list.get(0) + list.get(1) + list.get(2));
        if (signature.equals(mySignature)) {
            return echostr;
        }
        return "";
    }

}
