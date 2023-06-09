package cn.felord.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.contactbook.tag.Tag;
import cn.felord.domain.contactbook.tag.TagUserActionResponse;
import cn.felord.domain.contactbook.tag.TagUserRequest;
import cn.felord.domain.contactbook.tag.TagUserResponse;
import cn.felord.enumeration.WeComEndpoint;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 通讯录管理-标签管理
 * <p>
 * 标签属于应用
 *
 * @author felord.cn
 * @since 2021 /9/11
 */
public interface TagApi {

    /**
     * 创建标签
     *
     * @param request the request
     * @return GenericResponse generic response
     */
    @POST("tag/create")
    Single<GenericResponse<String>> createTag(@Body Tag request);

    /**
     * 更新标签名字
     *
     * @param request the request
     * @return WeComResponse we com response
     */
    @POST("tag/update")
    Single<WeComResponse> updateTag(@Body Tag request);

    /**
     * 删除标签
     *
     * @param tagId tagId
     * @return WeComResponse we com response
     */
    @GET("tag/delete")
    Single<WeComResponse> deleteTag(@Query("tagid") int tagId);

    /**
     * 获取标签成员
     *
     * @param tagId tagId
     * @return UserInfoResponse tag users
     */
    @GET("tag/get")
    Single<TagUserResponse> getTagUsers(@Query("tagid") int tagId);

    /**
     * 增加标签成员
     *
     * @param request the request
     * @return WeComResponse tag user action response
     */
    @POST("tag/addtagusers")
    Single<TagUserActionResponse> addTagUsers(@Body TagUserRequest request);

    /**
     * 删除标签成员
     *
     * @param request the request
     * @return WeComResponse tag user action response
     */
    @POST("tag/deltagusers")
    Single<TagUserActionResponse> deleteTagUsers(@Body TagUserRequest request);

    /**
     * 获取标签列表
     *
     * @return UserInfoResponse tags
     * @see WeComEndpoint#TAG_LIST WeComEndpoint#TAG_LISTWeComEndpoint#TAG_LIST
     */
    @GET("tag/list")
    Single<GenericResponse<Tag>> getTags();
}
