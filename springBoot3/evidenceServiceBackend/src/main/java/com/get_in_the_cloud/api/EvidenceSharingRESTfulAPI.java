package com.get_in_the_cloud.api;

import com.get_in_the_cloud.api.elasticSearchImpl.Evidence;
import org.springframework.http.ResponseEntity;

/**
 * Created by davicres on 24/11/2016.
 */
public interface EvidenceSharingRESTfulAPI {
    Evidence getEvidenceById(String evidenceId);
    ResponseEntity<Evidence> createEvidence(Evidence evidence);
}
