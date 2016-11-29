package com.get_in_the_cloud.api.elasticSearchImpl;

import com.get_in_the_cloud.api.EvidenceSharingRESTfulAPI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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
    public Evidence getEvidenceById(@PathVariable(required = true) String evidenceId) {
        RestTemplate restTemplate = new RestTemplate();
        String queryDSL = getQueryDSLToSearchByID(evidenceId);
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(
                "http://localhost:9200/evidences/evidence/_search").queryParam("source", queryDSL).build().encode();
        ElasticSearchResponse elasticSearchResponse = restTemplate.getForEntity(uriComponents.toUri(),
                ElasticSearchResponse.class).getBody();
        System.out.println(elasticSearchResponse);
        Evidence evidence = elasticSearchResponse.getHits().getHits().get(0).get_source();
        evidence.add(linkTo(methodOn(EvidenceSharingElasticSearchController.class).
                getEvidenceById(evidenceId)).slash(evidenceId).withSelfRel());
        return evidence;
    }

    private String getQueryDSLToSearchByID(String evidenceId) {
        return "{\n" +
                "    \"query\": {\n" +
                "        \"match\" : {\n" +
                "            \"evidenceID\" : \"" + evidenceId + "\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
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