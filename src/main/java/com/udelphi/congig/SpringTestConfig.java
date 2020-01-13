package com.udelphi.congig;

import com.udelphi.model.audit.CustomAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class SpringTestConfig {

    @Bean
    public AuditorAware auditorProvider(){
        return new CustomAuditorAware();
    }
}
