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

import cn.felord.WeComException;
import cn.felord.domain.journal.JournalDownloadRequest;
import cn.felord.domain.wedrive.FileDownloadResponse;
import cn.felord.domain.wedrive.FileId;
import cn.felord.domain.wedrive.SelectedTicket;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * The type File manager api.
 *
 * @author dax
 * @since 2024/3/17 15:02
 */
interface InternalFileManagerApi {

    /**
     * 下载文件（通过文件fileid）
     *
     * @param fileid the fileid
     * @return the file download response
     */
    @POST("wedrive/file_download")
    Single<FileDownloadResponse> getFileUrlByFileId(@Body FileId fileid);

    /**
     * 下载文件（微盘和文件选择器jsapi返回的selectedTicket）
     * <p>
     * 返回的下载链接和cookie值，通过下载链接带上{@code cookieName=cookieValue}Cookie请求头下载
     *
     * @param selectedTicket the selected ticket
     * @return the file download response
     */
    @POST("wedrive/file_download")
    Single<FileDownloadResponse> getFileUrlBySelectedTicket(@Body SelectedTicket selectedTicket);

    /**
     * 下载微盘文件（汇报应用）
     *
     * @param request the request
     * @return the single
     * @throws WeComException the weComException
     */
    @POST("oa/journal/download_wedrive_file")
    Single<FileDownloadResponse> downloadWedriveFile(@Body JournalDownloadRequest request) throws WeComException;
}
