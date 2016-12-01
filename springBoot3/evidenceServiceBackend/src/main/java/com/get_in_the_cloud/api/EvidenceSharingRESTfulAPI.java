package com.get_in_the_cloud.api;

import com.get_in_the_cloud.api.domain.evidence.Evidence;

/**
 * Created by davicres on 24/11/2016.
 */
public interface EvidenceSharingRESTfulAPI<T> {
    Evidence getEvidenceById(String evidenceId);
    T createEvidence(Evidence evidence);
}
