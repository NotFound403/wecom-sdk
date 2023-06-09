package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.common.CursorPage;
import cn.felord.domain.externalcontact.OffTransferCustomerRequest;
import cn.felord.domain.externalcontact.TransferCustomerResponse;
import cn.felord.domain.externalcontact.TransferFailedGroupChat;
import cn.felord.domain.externalcontact.TransferGroupChatRequest;
import cn.felord.domain.externalcontact.TransferResultRequest;
import cn.felord.domain.externalcontact.TransferResultResponse;
import cn.felord.domain.externalcontact.UnassignedListResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.Set;

/**
 * 离职继承
 *
 * @author dax
 * @since 2021 /9/14 13:59
 */
public interface OffTransferApi {

    /**
     * 获取待分配的离职成员列表
     *
     * @param cursorPage the cursor page
     * @return TransferCustomerResponse transfer customer response
     */
    @POST("externalcontact/get_unassigned_list")
    Single<UnassignedListResponse> getUnassignedList(@Body CursorPage cursorPage);


    /**
     * 分配离职成员的客户
     *
     * @param request the request
     * @return the transfer customer response
     */
    @POST("externalcontact/resigned/transfer_customer")
    Single<TransferCustomerResponse> transferCustomer(@Body OffTransferCustomerRequest request);

    /**
     * 查询离职成员客户接替状态
     *
     * @param request the request
     * @return the transfer customer response
     */
    @POST("externalcontact/resigned/transfer_result")
    Single<TransferResultResponse> transferResult(@Body TransferResultRequest request);

    /**
     * 分配离职成员的客户群
     *
     * @param request the request
     * @return the transfer result response
     */
    @POST("externalcontact/groupchat/transfer")
    Single<GenericResponse<Set<TransferFailedGroupChat>>> transferGroupChat(@Body TransferGroupChatRequest request);
}
