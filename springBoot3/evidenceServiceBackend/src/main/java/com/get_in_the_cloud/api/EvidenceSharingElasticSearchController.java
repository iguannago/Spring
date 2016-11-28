package com.get_in_the_cloud.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/EvidenceSharingAPI/evidences")
@Api(value = "/evidences", description = "Evidences REST API")
public class EvidenceSharingElasticSearchController implements EvidenceSharingRESTfulAPI {

    @GetMapping("/{evidenceId}")
    @ApiOperation(value = "Get an Evidence", notes = "Get an Evidence given an ID")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Evidence.class)
    })
    public ResponseEntity<Evidence> getEvidenceById(@PathVariable(required = true) String evidenceId) {
        Evidence evidence = new Evidence(evidenceId, "Appeal to the Social Security and Child Support Tribunal");
        evidence.add(linkTo(methodOn(EvidenceSharingElasticSearchController.class).getEvidenceById(evidenceId)).
                slash(evidenceId).withSelfRel());
        return new ResponseEntity<>(evidence, HttpStatus.OK);
    }

    @PostMapping()
    @ApiOperation(value = "Post an Evidence", notes = "Create an Evidence from the JSON payload in the post request")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Created", response = Evidence.class)
    })
    public ResponseEntity<Evidence> createEvidence(@RequestBody Evidence evidence) {
        evidence.add(linkTo(methodOn(EvidenceSharingElasticSearchController.class).createEvidence(evidence)).
                withSelfRel());
        return new ResponseEntity<>(evidence, HttpStatus.CREATED);
    }

}