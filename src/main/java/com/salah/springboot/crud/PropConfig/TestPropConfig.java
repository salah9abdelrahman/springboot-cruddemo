package com.salah.springboot.crud.PropConfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "thisisprefix")
@Getter
@Setter
public class TestPropConfig {

    /**
     * Ha ha Nama Btklm
     */
    private String aProp;

    private int num;

    private List<String> listProp;

}
