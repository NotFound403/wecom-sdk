package cn.felord.api;

import cn.felord.domain.wedrive.FileDownloadResponse;
import cn.felord.domain.wedrive.FileId;
import cn.felord.domain.wedrive.SelectedTicket;
import cn.felord.retrofit.RetrofitFactory;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * The type File manager api.
 *
 * @author xiafang
 * @since 2023 /6/26 17:07
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
        this.downloadApi = RetrofitFactory.RETROFIT_.create(DownloadApi.class);
    }

    /**
     * 下载文件（通过文件fileid）
     *
     * @param fileid the fileid
     * @return the file download response
     */
    public ResponseBody downloadByFileId(String fileid) {
        FileDownloadResponse downloadResponse = internalFileManagerApi.getFileUrlByFileId(new FileId(fileid));
        return this.download(downloadResponse);
    }

    /**
     * 下载文件（微盘和文件选择器jsapi返回的selectedTicket）
     *
     * @param selectedTicket the selected ticket
     * @return the file download response
     */
    public ResponseBody downloadBySelectedTicket(String selectedTicket) {
        FileDownloadResponse downloadResponse = internalFileManagerApi.getFileUrlBySelectedTicket(new SelectedTicket(selectedTicket));
        return this.download(downloadResponse);
    }

    private ResponseBody download(FileDownloadResponse downloadResponse) {
        String downloadUrl = downloadResponse.getDownloadUrl();
        String cookie = downloadResponse.getCookieName()
                .concat("=")
                .concat(downloadResponse.getCookieValue());
        return downloadApi.download(downloadUrl, cookie);
    }


    interface DownloadApi {
        @POST
        ResponseBody download(@Url String downloadUrl, @Header("Cookie") String cookie);
    }

}
