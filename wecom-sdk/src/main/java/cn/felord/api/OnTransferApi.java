package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.externalcontact.TransferCustomerRequest;
import cn.felord.domain.externalcontact.TransferCustomerResponse;
import cn.felord.domain.externalcontact.TransferFailedGroupChat;
import cn.felord.domain.externalcontact.TransferGroupChatRequest;
import cn.felord.domain.externalcontact.TransferResultRequest;
import cn.felord.domain.externalcontact.TransferResultResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.Set;

/**
 * 在职继承
 *
 * @author dax
 * @since 2021 /9/14 13:59
 */
public interface OnTransferApi {

    /**
     * 分配在职成员的客户
     * <p>
     * 为保障客户服务体验，90个自然日内，在职成员的每位客户仅可被转接2次。
     *
     * @param request the request
     * @return TransferCustomerResponse transfer customer response
     */
    @POST("externalcontact/transfer_customer")
    Single<TransferCustomerResponse> transferCustomer(@Body TransferCustomerRequest request);

    /**
     * 查询客户接替状态
     *
     * @param request the request
     * @return the transfer customer response
     */
    @POST("externalcontact/transfer_result")
    Single<TransferResultResponse> transferResult(@Body TransferResultRequest request);

    /**
     * 分配在职成员的客户群
     *
     * @param request the request
     * @return the transfer result response
     */
    @POST("externalcontact/groupchat/onjob_transfer")
    Single<GenericResponse<Set<TransferFailedGroupChat>>> transferGroupChat(@Body TransferGroupChatRequest request);
}
