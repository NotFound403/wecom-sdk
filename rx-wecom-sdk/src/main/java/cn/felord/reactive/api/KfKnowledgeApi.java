package cn.felord.reactive.api;

import cn.felord.domain.WeComResponse;
import cn.felord.domain.callcenter.knowledge.GroupsRequest;
import cn.felord.domain.callcenter.knowledge.GroupsResponse;
import cn.felord.domain.callcenter.knowledge.KnowledgeGroup;
import cn.felord.domain.common.GroupId;
import cn.felord.domain.common.Name;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 微信客服-机器人-知识库API
 *
 * @author dax
 * @since 2023 /10/5
 */
public interface KfKnowledgeApi {

    /**
     * 添加分组
     * <p>
     * 可通过此接口创建新的知识库分组。
     *
     * @param name the name
     * @return the we com response
     */
    @POST("kf/knowledge/add_group")
    Single<WeComResponse> addGroup(@Body Name name);

    /**
     * 删除分组
     * <p>
     * 可通过此接口删除已有的知识库分组，但不能删除系统创建的默认分组。
     *
     * @param groupId the group id
     * @return the we com response
     */
    @POST("kf/knowledge/del_group")
    Single<WeComResponse> delGroup(@Body GroupId groupId);

    /**
     * 修改分组
     * <p>
     * 可通过此接口修改已有的知识库分组，但不能修改系统创建的默认分组。
     *
     * @param group the group
     * @return the we com response
     */
    @POST("kf/knowledge/mod_group")
    Single<WeComResponse> modGroup(@Body KnowledgeGroup group);

    /**
     * 获取分组列表
     * <p>
     * 可通过此接口分页获取所有的知识库分组。
     *
     * @param request the request
     * @return the groups response
     */
    @POST("kf/knowledge/list_group")
    Single<GroupsResponse> listGroup(@Body GroupsRequest request);
}
