package cn.felord.api;

import cn.felord.WeComException;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.callcenter.knowledge.GroupsRequest;
import cn.felord.domain.callcenter.knowledge.GroupsResponse;
import cn.felord.domain.callcenter.knowledge.KnowledgeGroup;
import cn.felord.domain.common.GroupId;
import cn.felord.domain.common.Name;
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
     * @throws WeComException the weComException
     */
    @POST("kf/knowledge/add_group")
    WeComResponse addGroup(@Body Name name) throws WeComException;

    /**
     * 删除分组
     * <p>
     * 可通过此接口删除已有的知识库分组，但不能删除系统创建的默认分组。
     *
     * @param groupId the group id
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("kf/knowledge/del_group")
    WeComResponse delGroup(@Body GroupId groupId) throws WeComException;

    /**
     * 修改分组
     * <p>
     * 可通过此接口修改已有的知识库分组，但不能修改系统创建的默认分组。
     *
     * @param group the group
     * @return the we com response
     * @throws WeComException the weComException
     */
    @POST("kf/knowledge/mod_group")
    WeComResponse modGroup(@Body KnowledgeGroup group) throws WeComException;

    /**
     * 获取分组列表
     * <p>
     * 可通过此接口分页获取所有的知识库分组。
     *
     * @param request the request
     * @return the groups response
     * @throws WeComException the weComException
     */
    @POST("kf/knowledge/list_group")
    GroupsResponse listGroup(@Body GroupsRequest request) throws WeComException;
}
