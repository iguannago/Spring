package com.get_in_the_cloud.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EvidenceSharingService/evidences")
@Api(value = "/evidences", description = "Evidences REST API")
public class EvidenceSharingController {

    @GetMapping("/get/{evidenceId}")
    @ApiOperation(value = "Get an Evidence", notes = "Get an Evidence given an ID")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = Evidence.class)
    })
    public Evidence getEvidenceById(@PathVariable String evidenceId) {
        return Evidence.builder(evidenceId, "Appeal to the Social Security and Child Support Tribunal");
    }

}