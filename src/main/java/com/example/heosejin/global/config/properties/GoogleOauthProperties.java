package com.example.heosejin.global.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("google")
public class GoogleOauthProperties {
    private String clientId;
    private String secretKey;
    private String redirectUri;
}
