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

package cn.felord.api;

import cn.felord.WeComException;
import cn.felord.domain.MultipartResource;
import cn.felord.domain.GenericResponse;
import cn.felord.domain.common.JobId;
import cn.felord.domain.media.MediaJobResponse;
import cn.felord.domain.media.MediaResponse;
import cn.felord.domain.media.MediaUploadRequest;
import cn.felord.enumeration.MediaAttachmentType;
import cn.felord.enumeration.MediaTypeEnum;
import cn.felord.utils.MediaUtil;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.http.Body;

/**
 * 素材管理
 *
 * @author dax
 * @since 2024/6/10 17:09
 */
public class MediaApi {
    private final InternalMediaApi internalMediaApi;


    /**
     * Instantiates a new Media api.
     *
     * @param retrofit the retrofit
     */
    MediaApi(Retrofit retrofit) {
        this.internalMediaApi = retrofit.create(InternalMediaApi.class);
    }

    /**
     * 上传附件资源
     * <p>
     * 素材上传得到media_id，该media_id仅三天内有效
     * media_id在同一企业内应用之间可以共享
     *
     * @param mediaType      the media type
     * @param attachmentType the attachment type
     * @param resource       the resource
     * @return the media response
     * @throws WeComException the weComException
     */
    public MediaResponse uploadAttachment(MediaTypeEnum mediaType,
                                          MediaAttachmentType attachmentType,
                                          MultipartResource resource) throws WeComException {
        return internalMediaApi.uploadAttachment(mediaType.type(), attachmentType.getType(), MediaUtil.toMultipartBody(resource));
    }

    /**
     * 上传临时素材
     * <p>
     * 图片（image）：10MB，支持JPG,PNG格式
     * 语音（voice） ：2MB，播放长度不超过60s，仅支持AMR格式
     * 视频（video） ：10MB，支持MP4格式
     * 普通文件（file）：20MB
     *
     * @param mediaType the media type
     * @param resource  the resource
     * @return the media response
     * @throws WeComException the weComException
     */
    public MediaResponse uploadMedia(MediaTypeEnum mediaType, MultipartResource resource) throws WeComException {
        return internalMediaApi.uploadMedia(mediaType.type(), MediaUtil.toMultipartBody(resource));
    }

    /**
     * 上传图片
     * <p>
     * 上传图片得到图片URL，该URL永久有效
     * 返回的图片URL，仅能用于图文消息正文中的图片展示，或者给客户发送欢迎语等；若用于非企业微信环境下的页面，图片将被屏蔽。
     * 每个企业每月最多可上传3000张图片，每天最多可上传1000张图片
     *
     * @param resource the resource
     * @return the media response
     * @throws WeComException the weComException
     */
    public MediaResponse uploadImage(MultipartResource resource) throws WeComException {
        return internalMediaApi.uploadImage(MediaUtil.toMultipartBody(resource));
    }

    /**
     * 获取临时素材
     * TODO 待优化 需要根据不同的HTTP头进行处理
     *
     * @param mediaId the media id
     * @return the media
     * @throws WeComException the weComException
     */
    public ResponseBody getMedia(String mediaId) throws WeComException {
        return internalMediaApi.getMedia(mediaId);
    }

    /**
     * 获取高清语音素材
     * TODO 待优化 需要根据不同的HTTP头进行处理
     *
     * @param mediaId the media id
     * @return the media js sdk
     * @throws WeComException the weComException
     */
    public ResponseBody getMediaJsSdk(String mediaId) throws WeComException {
        return internalMediaApi.getMediaJsSdk(mediaId);
    }

    /**
     * 生成异步上传任务
     *
     * @param request the request
     * @return the single
     * @throws WeComException the weComException
     */
    public GenericResponse<String> uploadByUrl(MediaUploadRequest request) throws WeComException {
        return internalMediaApi.uploadByUrl(request);
    }

    /**
     * 查询异步任务结果
     *
     * @param jobId the job id
     * @return the upload by url result
     * @throws WeComException the weComException
     */
    public MediaJobResponse getUploadByUrlResult(@Body JobId jobId) throws WeComException {
        return internalMediaApi.getUploadByUrlResult(jobId);
    }

    /**
     * 创建对外收款账户-提交图片
     *
     * @param resource the resource
     * @return the generic response
     * @throws WeComException the weComException
     */
    public GenericResponse<String> uploadPayImage(MultipartResource resource) throws WeComException {
        return internalMediaApi.uploadPayImage(MediaUtil.toMultipartBody(resource));
    }
}
