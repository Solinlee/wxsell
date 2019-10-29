package com.solin.wxsell.controller.tool;

import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

@RestController
public class wxController {

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
