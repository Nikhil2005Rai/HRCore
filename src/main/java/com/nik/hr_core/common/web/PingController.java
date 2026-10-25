package com.nik.hr_core.common.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PingController {
    private final String companyName;
    private final int maxCarryForward;

    public PingController(@Value("${company.name}") String companyName,
                          @Value("${leave.max-carry-forward}") int maxCarryForward) {
        this.companyName = companyName;
        this.maxCarryForward = maxCarryForward;
    }

    @GetMapping("/ping")
    public Map<String, Object> ping() {
        return Map.of("status", "ok", "company", companyName, "maxCarryForward", maxCarryForward);
    }
}
