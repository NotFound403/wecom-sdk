package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.common.DepartmentId;
import cn.felord.domain.common.UserId;
import cn.felord.domain.contactbook.department.DeptInfo;
import cn.felord.domain.contactbook.linkedcorp.CorpSimpleUserInfo;
import cn.felord.domain.contactbook.linkedcorp.CorpUserInfo;
import cn.felord.domain.contactbook.linkedcorp.PermListResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * 互联企业通讯录
 *
 * @author felord.cn
 * @since 2021 /8/29 16:39
 */
public interface LinkedCorpApi {
    /**
     * 获取应用的可见范围
     *
     * @return the perm list
     */
    @POST("linkedcorp/agent/get_perm_list")
    Single<PermListResponse> getPermList();

    /**
     * 获取互联企业成员详细信息
     *
     * @param userId the user id
     * @return the user
     */
    @POST("linkedcorp/user/get")
    Single<GenericResponse<CorpUserInfo>> getUser(UserId userId);

    /**
     * 获取互联企业部门成员
     *
     * @param linkedDepartmentId the linked department id
     * @return the generic response
     */
    @POST("linkedcorp/user/simplelist")
    Single<GenericResponse<List<CorpSimpleUserInfo>>> getUserSimplelist(@Body DepartmentId linkedDepartmentId);

    /**
     * 获取互联企业部门列表
     *
     * @param linkedDepartmentId the linked department id
     * @return the dept list
     */
    @POST("linkedcorp/department/list")
    Single<GenericResponse<List<DeptInfo>>> getDeptList(@Body DepartmentId linkedDepartmentId);
}
