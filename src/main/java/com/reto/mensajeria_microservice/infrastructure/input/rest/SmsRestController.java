package com.reto.mensajeria_microservice.infrastructure.input.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reto.mensajeria_microservice.domain.api.SmsService;

@RestController
@RequestMapping("/sms/")
public class SmsRestController {

    private final SmsService smsService;

    public SmsRestController(SmsService smsService) {
        this.smsService = smsService;
    }

    @GetMapping("send")
    public void sendSms(@RequestParam String toPhoneNumber, @RequestParam String message) {
        smsService.sendSms(toPhoneNumber, message);
    }
}
