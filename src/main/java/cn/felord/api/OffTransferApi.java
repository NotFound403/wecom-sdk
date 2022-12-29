package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.externalcontact.OffTransferCustomerRequest;
import cn.felord.domain.externalcontact.TransferCustomerResponse;
import cn.felord.domain.externalcontact.TransferFailedGroupChat;
import cn.felord.domain.externalcontact.TransferGroupChatRequest;
import cn.felord.domain.externalcontact.TransferResultRequest;
import cn.felord.domain.externalcontact.TransferResultResponse;
import cn.felord.domain.externalcontact.UnassignedListResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 离职继承
 *
 * @author dax
 * @since 2021 /9/14 13:59
 */
public class OffTransferApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Off transfer api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    OffTransferApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }


    /**
     * 获取待分配的离职成员列表
     *
     * @param cursor   the cursor
     * @param pageSize the page size
     * @return TransferCustomerResponse transfer customer response
     */
    public UnassignedListResponse getUnassignedList(String cursor, int pageSize) {

        String endpoint = WeComEndpoint.UNASSIGNED_LIST.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        Map<String, Object> body = new HashMap<>(2);
        body.put("cursor", cursor);
        body.put("page_size", pageSize);
        return workWeChatApiClient.post(uri, body, UnassignedListResponse.class);
    }


    /**
     * 分配离职成员的客户
     *
     * @param request the request
     * @return the transfer customer response
     */
    public TransferCustomerResponse transferCustomer(OffTransferCustomerRequest request) {

        String endpoint = WeComEndpoint.OFF_TRANSFER_CUSTOMER.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, TransferCustomerResponse.class);
    }

    /**
     * 查询离职成员客户接替状态
     *
     * @param request the request
     * @return the transfer customer response
     */
    public TransferResultResponse transferResult(TransferResultRequest request) {

        String endpoint = WeComEndpoint.OFF_TRANSFER_RESULT.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, TransferResultResponse.class);
    }

    /**
     * 分配离职成员的客户群
     *
     * @param request the request
     * @return the transfer result response
     */
    public GenericResponse<Set<TransferFailedGroupChat>> transferGroupChat(TransferGroupChatRequest request) {

        String endpoint = WeComEndpoint.OFF_TRANSFER_GROUP_CHAT.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return workWeChatApiClient.post(uri, request, new ParameterizedTypeReference<GenericResponse<Set<TransferFailedGroupChat>>>() {
        });
    }
}
