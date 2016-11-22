package com.get_in_the_cloud.backend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvidenceShareController {

    @RequestMapping("/EvidenceShareService/evidences/get")
    String getEvidence() {
        return "Evidence Share API";
    }

}
