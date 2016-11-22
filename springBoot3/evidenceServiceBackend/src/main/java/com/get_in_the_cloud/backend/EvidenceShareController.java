package com.get_in_the_cloud.backend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EvidenceShareService/evidences")
public class EvidenceShareController {

    @RequestMapping(path = "/get/{id}")
    String getEvidence() {
        return "Evidence Share API";
    }

}
