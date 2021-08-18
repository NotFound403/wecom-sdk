package cn.felord.api.contactbook;

import cn.felord.ContactBookAgent;
import cn.felord.api.AbstractApi;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.contactbook.async.BatchPartyRequest;
import cn.felord.domain.contactbook.async.BatchResultResponse;
import cn.felord.domain.contactbook.async.BatchUserRequest;
import cn.felord.enumeration.WeComDomain;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * 异步
 *
 * @author n1
 * @since 2021 /6/18 16:25
 */
public class AsynchronousBatchApi extends AbstractApi {

    /**
     * Agent asynchronous batch api.
     *
     * @param contactBookAgent the contact book agent
     * @return the asynchronous batch api
     */
    public AsynchronousBatchApi agent(ContactBookAgent contactBookAgent) {
        this.withAgent(contactBookAgent);
        return this;
    }

    /**
     * Batch sync user generic response.
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<String> batchSyncUser(BatchUserRequest request) {
        String endpoint = WeComEndpoint.BATCH_SYNC_USER.endpoint(WeComDomain.CGI_BIN);
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * Batch sync replace user generic response.
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<String> batchSyncReplaceUser(BatchUserRequest request) {
        String endpoint = WeComEndpoint.BATCH_REPLACE_USER.endpoint(WeComDomain.CGI_BIN);
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * Batch sync replace party generic response.
     *
     * @param request the request
     * @return the generic response
     */
    public GenericResponse<String> batchSyncReplaceParty(BatchPartyRequest request) {
        String endpoint = WeComEndpoint.BATCH_REPLACE_PARTY.endpoint(WeComDomain.CGI_BIN);
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, new ParameterizedTypeReference<GenericResponse<String>>() {
        });
    }

    /**
     * Gets result.
     *
     * @param jobId the job id
     * @return the result
     */
    public BatchResultResponse getResult(String jobId) {
        String endpoint = WeComEndpoint.BATCH_GET_RESULT.endpoint(WeComDomain.CGI_BIN);
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("jobid", jobId)
                .build()
                .toUri();
        return this.get(uri, BatchResultResponse.class);
    }
}
