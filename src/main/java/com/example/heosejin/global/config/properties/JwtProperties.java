package com.example.heosejin.global.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties("jwt")
@Setter
public class JwtProperties {
    private Long accessExp;
    private Long refreshExp;
    private String prefix;
    private String header;
    private String secretKey;
}
