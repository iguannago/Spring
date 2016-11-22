package com.get_in_the_cloud.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class EvidenceShare {

    @RequestMapping("/EvidenceShareService/evidences/get")
    String getEvidence() {
        return "Evidence Share API";
    }

    public static void main(String[] args) {
        SpringApplication.run(EvidenceShare.class, args);
    }

}
