package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.callcenter.KfAccountAddRequest;
import cn.felord.domain.callcenter.KfAccountInfo;
import cn.felord.domain.callcenter.KfAccountLinkRequest;
import cn.felord.domain.callcenter.KfAccountListRequest;
import cn.felord.domain.callcenter.KfAccountUpdateRequest;
import cn.felord.domain.callcenter.OpenKfid;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 客服账号管理
 *
 * @author dax
 * @since 2021 /7/23 13:52
 */
public interface KfAccountApi {

    /**
     * 添加客服账号
     *
     * @param request the request
     * @return the generic response
     */
    @POST("kf/account/add")
    Single<GenericResponse<String>> addKfAccount(@Body KfAccountAddRequest request);

    /**
     * 删除客服账号
     *
     * @param openKfid the open kfid
     * @return the we com response
     */
    @POST("kf/account/del")
    Single<WeComResponse> delKfAccount(@Body OpenKfid openKfid);

    /**
     * 修改客服账号
     *
     * @param request the request
     * @return the we com response
     */
    @POST("kf/account/update")
    Single<WeComResponse> updateKfAccount(@Body KfAccountUpdateRequest request);

    /**
     * 获取客服账号列表
     *
     * @param request the request
     * @return the generic response
     */
    @POST("kf/account/list")
    Single<GenericResponse<List<KfAccountInfo>>> kfAccountList(KfAccountListRequest request);

    /**
     * 获取客服账号链接
     *
     * @param request the request
     * @return the generic response
     */
    @POST("kf/add_contact_way")
    Single<GenericResponse<String>> kfAccountLink(@Body KfAccountLinkRequest request);
}
