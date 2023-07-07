package org.acme;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VelocityTest extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        JacksonDataFormat dataFormat = new JacksonDataFormat();

        from("timer:hello?period=1000")
        .log("processing body")
        .transform().constant("[{\"id\":1,\"first_name\":\"Sandor\",\"last_name\":\"Galton\",\"email\":\"sgalton0@so-net.ne.jp\",\"gender\":\"Male\",\"ip_address\":\"249.141.248.147\"},\n" + //
                "{\"id\":2,\"first_name\":\"Daveta\",\"last_name\":\"Bonhan\",\"email\":\"dbonhan1@phpbb.com\",\"gender\":\"Female\",\"ip_address\":\"198.169.240.84\"},\n" + //
                "{\"id\":3,\"first_name\":\"Mill\",\"last_name\":\"Joder\",\"email\":\"mjoder2@altervista.org\",\"gender\":\"Male\",\"ip_address\":\"72.33.207.18\"}]")
        .log("input ${body}")
        .unmarshal(dataFormat)
        .to("velocity:response.vm")
        .log("output ${body}")
        .end();
               
    }

}