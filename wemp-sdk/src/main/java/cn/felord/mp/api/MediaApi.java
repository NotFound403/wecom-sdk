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

import cn.felord.domain.MultipartResource;
import cn.felord.mp.WeMpException;
import cn.felord.mp.domain.media.MediaUrl;
import cn.felord.utils.MediaUtil;
import retrofit2.Retrofit;

/**
 * 公众号媒体管理
 *
 * @author dax
 * @since 2024/8/18 9:16
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
     * 上传图片接口
     *
     * @param resource the resource
     * @return the media url
     * @throws WeMpException the we mp exception
     */
    public MediaUrl uploadImg(MultipartResource resource) throws WeMpException {
        return internalMediaApi.uploadImg(MediaUtil.toMultipartBody(resource));
    }
}
