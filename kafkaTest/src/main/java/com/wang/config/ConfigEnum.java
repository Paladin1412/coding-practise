package com.wang.config;

/**
 * @Description:
 * @Author: wangyinghao
 * @Date: 2020-06-06 19:28
 **/
public enum ConfigEnum {
    BOOTSTRAP_SERVERS_CONFIG("BOOTSTRAP_SERVERS_CONFIG", "dc-resource-112f0ce5b-48.qiyi.virtual:9092," +
            "dc-resource-112f0ce5b-49.qiyi.virtual:9092,dc-resource-112f0ce5b-50.qiyi.virtual:9092," +
            "dc-resource-fb597f31-1.qiyi.virtual:9092,dc-resource-fb597f31-2.qiyi.virtual:9092"),
    STRING_SERIALIZER("STRING_SERIALIZER", "org.apache.kafka.common.serialization.StringSerializer");
    private String name;
    private String value;

    ConfigEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
