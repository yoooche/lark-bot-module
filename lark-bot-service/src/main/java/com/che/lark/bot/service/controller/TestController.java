package com.che.lark.bot.service.controller;

import com.che.lark.bot.service.constants.LarkCredentials;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/test")
@RestController
public class TestController {

    @PostMapping
    public ResponseEntity<Map<String, Object>> testConnection(@RequestBody Map<String, Object> payload) {
        var larkVerifyToken = System.getenv(LarkCredentials.LARK_VERIFY_TOKEN.name());
        if ("url_verification".equals(payload.get("type"))) {

            if (!larkVerifyToken.equals(payload.get("token"))) {
                return ResponseEntity.ok(Map.of("success", false, "message", "Invalid token"));
            }
            return ResponseEntity.ok(Map.of("challenge", payload.get("challenge")));
        }
        return ResponseEntity.ok(Map.of("success", false));
    }
}
