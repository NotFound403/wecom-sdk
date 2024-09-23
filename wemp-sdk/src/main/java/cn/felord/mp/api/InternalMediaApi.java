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

package cn.felord.mp.api;

import cn.felord.mp.WeMpException;
import cn.felord.mp.domain.media.MediaUrl;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 公众号素材上传
 *
 * @author dax
 * @since 2024/8/18 9:17
 */
public interface InternalMediaApi {
    /**
     * 上传图片接口
     * <p>
     * 上传的图片限制文件大小限制1MB，仅支持JPG、PNG格式。
     *
     * @param media the media
     * @return the response body
     * @throws WeMpException the we mp exception
     */
    @POST("cgi-bin/media/uploadimg")
    MediaUrl uploadImg(@Body MultipartBody media) throws WeMpException;
}
