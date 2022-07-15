package com.elena.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties",
        "classpath:config/remote.properties"
})
public interface ProjectConfig extends Config {

    @Key("browser")
    String browser();
    @Key("browserVersion")
    @DefaultValue("99.0")
    String browserVersion();
    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();
    String browserMobileView();
    @Key("remoteDriverUrl")
    String remoteDriverUrl();
    @Key("videoStorage")
    String videoStorage();
    @DefaultValue("https://www.wildberries.ru/")
    String webUrl();
}
