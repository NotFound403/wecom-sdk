package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComCacheable;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.externalcontact.*;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Set;

/**
 * 在职继承
 *
 * @author dax
 * @since 2021 /9/14 13:59
 */
public class OnTransferApi extends AbstractAgentApi {
    /**
     * Instantiates a new On transfer api.
     *
     * @param wecomCacheable the wecom cacheable
     * @param agent          the agent
     */
    OnTransferApi(WeComCacheable wecomCacheable, AgentDetails agent) {
        super(wecomCacheable, agent);
    }

    /**
     * 分配在职成员的客户
     * <p>
     * 为保障客户服务体验，90个自然日内，在职成员的每位客户仅可被转接2次。
     *
     * @param request the request
     * @return TransferCustomerResponse transfer customer response
     */
    public TransferCustomerResponse transferCustomer(TransferCustomerRequest request) {

        String endpoint = WeComEndpoint.TRANSFER_CUSTOMER.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, TransferCustomerResponse.class);
    }

    /**
     * 查询客户接替状态
     *
     * @param request the request
     * @return the transfer customer response
     */
    public TransferResultResponse transferResult(TransferResultRequest request) {

        String endpoint = WeComEndpoint.TRANSFER_RESULT.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, TransferResultResponse.class);
    }

    /**
     * 分配在职成员的客户群
     *
     * @param request the request
     * @return the transfer result response
     */
    public GenericResponse<Set<TransferFailedGroupChat>> transferGroupChat(TransferGroupChatRequest request) {

        String endpoint = WeComEndpoint.TRANSFER_GROUP_CHAT.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return this.post(uri, request, new ParameterizedTypeReference<GenericResponse<Set<TransferFailedGroupChat>>>() {
        });
    }
}
