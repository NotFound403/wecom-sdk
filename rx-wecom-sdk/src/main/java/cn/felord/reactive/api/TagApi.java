/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.reactive.api;

import cn.felord.domain.GenericResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.contactbook.tag.Tag;
import cn.felord.domain.contactbook.tag.TagUserActionResponse;
import cn.felord.domain.contactbook.tag.TagUserRequest;
import cn.felord.domain.contactbook.tag.TagUserResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

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
     */
    @GET("tag/list")
    Single<GenericResponse<List<Tag>>> getTags();
}
