package com.udelphi.model.audit;


import java.util.Optional;
import org.springframework.data.domain.AuditorAware;

public class CustomAuditorAware implements AuditorAware<String> {

    public Optional<String> getCurrentAuditor() {
        return Optional.of("admin");
    }
}