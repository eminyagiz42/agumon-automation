package com.agumon.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;


@LoadPolicy(LoadType.MERGE)
@Sources({"system:properties", "classpath:configuration.properties"})
public interface MainConfig extends Config {

    @Key("sendgrid.mail.from.name")
    String fromName();

    @Key("sendgrid.template.request.customer")
    String requestUserTemplate();

    @Key("sendgrid.mail.send.domain")
    String mailSendDomain();

    @Key("sendgrid.token")
    String token();

    @Key("sendgrid.from.account")
    String fromAccount();

    @Key("sendgrid.send.to.account")
    String sendTo();

}