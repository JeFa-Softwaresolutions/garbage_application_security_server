package de.jefa.garbage_application_security_server.api.config;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;

public class CustomCsrfConfigurer implements Customizer<CsrfConfigurer<HttpSecurity>> {

    @Override
    public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
        httpSecurityCsrfConfigurer.disable();
    }
}
