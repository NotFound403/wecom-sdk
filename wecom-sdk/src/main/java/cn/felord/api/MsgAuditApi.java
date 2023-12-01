package cn.felord.api;

import cn.felord.WeComException;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.msgaudit.AgreeDetail;
import cn.felord.domain.msgaudit.AgreeInfoRequest;
import cn.felord.domain.msgaudit.PermitUsersRequest;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 会话存档API
 *
 * @author dax
 * @since 2023 /12/1
 */
public interface MsgAuditApi {

    /**
     * 获取会话内容存档开启成员列表
     * <p>
     * 企业可通过此接口，获取企业开启会话内容存档的成员列表
     * <p>
     * 注：开启范围可设置为具体成员、部门、标签。
     * 通过此接口拉取成员列表，会将部门、标签进行打散处理，获取部门、标签范围内的全部成员。
     * 最终以成员userid的形式返回。
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("msgaudit/get_permit_user_list")
    GenericResponse<List<String>> getPermitUserList(@Body PermitUsersRequest request) throws WeComException;

    /**
     * 获取会话同意情况
     * <p>
     * 备注说明：目前一次请求只支持最多100个查询条目，超过此限制的请求会被拦截，请调用方减少单次请求的查询个数。
     *
     * @param request the request
     * @return the generic response
     * @throws WeComException the weComException
     */
    @POST("msgaudit/check_single_agree")
    GenericResponse<List<AgreeDetail>> checkSingleAgree(@Body AgreeInfoRequest request) throws WeComException;
}
