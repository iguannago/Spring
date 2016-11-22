package com.get_in_the_cloud.restServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EvidenceShareService/evidences")
public class EvidenceShareController {

    @GetMapping("/get/{evidenceId}")
    public String getEvidenceById(@PathVariable String evidenceId) {
        return "Evidence ID is: " + evidenceId;
    }

}