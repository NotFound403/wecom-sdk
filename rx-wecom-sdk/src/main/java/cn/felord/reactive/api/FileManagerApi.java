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

import cn.felord.domain.journal.JournalDownloadRequest;
import cn.felord.domain.wedrive.BufferSource;
import cn.felord.domain.wedrive.FileDownloadResponse;
import cn.felord.domain.wedrive.FileId;
import cn.felord.domain.wedrive.SelectedTicket;
import cn.felord.retrofit.WorkWechatRetrofitFactory;
import io.reactivex.rxjava3.core.Single;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * The type File manager api.
 *
 * @author dax
 * @since 2024/6/26 17:07
 */
public class FileManagerApi {
    private final InternalFileManagerApi internalFileManagerApi;
    private final DownloadApi downloadApi;

    /**
     * Instantiates a new File manager api.
     *
     * @param retrofit the retrofit
     */
    FileManagerApi(Retrofit retrofit) {
        this.internalFileManagerApi = retrofit.create(InternalFileManagerApi.class);
        this.downloadApi = WorkWechatRetrofitFactory.RETROFIT_.create(DownloadApi.class);
    }

    /**
     * 下载文件（通过文件fileid）
     *
     * @param fileid the fileid
     * @return the file download response
     */
    public Single<BufferSource> downloadByFileId(String fileid) {
        return internalFileManagerApi.getFileUrlByFileId(new FileId(fileid))
                .flatMap(this::download);
    }

    /**
     * 下载文件（微盘和文件选择器jsapi返回的selectedTicket）
     *
     * @param selectedTicket the selected ticket
     * @return the file download response
     */
    public Single<BufferSource> downloadBySelectedTicket(String selectedTicket) {
        return internalFileManagerApi.getFileUrlBySelectedTicket(new SelectedTicket(selectedTicket))
                .flatMap(this::download);
    }

    /**
     * 下载微盘文件（汇报应用）
     *
     * @param request the request
     * @return the single
     */
    public Single<BufferSource> downloadBySelectedTicket(JournalDownloadRequest request) {
        return internalFileManagerApi.downloadWedriveFile(request)
                .flatMap(this::download);
    }

    private Single<BufferSource> download(FileDownloadResponse downloadResponse) {
        String downloadUrl = downloadResponse.getDownloadUrl();
        String cookie = downloadResponse.getCookieName()
                .concat("=")
                .concat(downloadResponse.getCookieValue());
        return downloadApi.download(downloadUrl, cookie)
                .map(body ->
                        new BufferSource(body.contentType(), body.contentLength(), body.source()));

    }

    /**
     * 微盘文件下载
     */
    interface DownloadApi {
        /**
         * 文件下载
         *
         * @param downloadUrl the download url
         * @param cookie      the cookie
         * @return the response body
         */
        @POST
        Single<ResponseBody> download(@Url String downloadUrl, @Header("Cookie") String cookie);
    }

}
