package com.cdspseminar.notefolio.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
public class ProfileController {

    private final Environment env;
    private static final String NULL = "";

    @GetMapping
    public String getProfile() {
        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse(NULL);
    }

    @GetMapping("/v2")
    public String getProfileV2() {
        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse(NULL);
    }
}
