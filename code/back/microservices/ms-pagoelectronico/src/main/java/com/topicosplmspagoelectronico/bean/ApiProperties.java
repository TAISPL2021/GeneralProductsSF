package com.topicosplmspagoelectronico.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@Configuration
@PropertySource("classpath:static/apiConfig.properties")
public class ApiProperties {

    @Value("${api.apiKey}")
    private String apiKey;
    @Value("${api.apiLogin}")
    String apiLogin;
    @Value("${api.accountId}")
    String accountId;
    @Value("${api.merchantId}")
    String merchantId;
    @Value("${api.paymentsUrl}")
    String paymentsUrl;
    @Value("${api.reportsUrl}")
    String reportsUrl;
    @Value("${api.reference}")
    String reference;
    @Value("${api.Language}")
    String language;
    @Value("${api.installments}")
    String installments;
    @Value("${api.ipAddress}")
    String ipAddress;
    @Value("${api.country}")
    String country;
    @Value("${api.description}")
    String description;
}