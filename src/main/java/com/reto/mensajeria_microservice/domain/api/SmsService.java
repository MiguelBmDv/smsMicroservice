package com.reto.mensajeria_microservice.domain.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SmsService {

    @Value("${twilio.account-sid}")
    private String accountdSid;

    @Value("${twilio.auth-token}")
    private String authToken;

    @Value("${twilio.phone-number}")
    private String twilioPhoneNumber;

    public void sendSms(String toPhoneNumber, String message) {
        Twilio.init(accountdSid, authToken);
        
        Message.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(twilioPhoneNumber),
                message
        ).create();
    }
}
