package cn.felord.mp.api;

import cn.felord.mp.WeMpException;
import cn.felord.mp.domain.MpResponse;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 公众号素材上传
 *
 * @author xiafang
 * @since 2023 /8/18 9:17
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
    MpResponse<String> uploadImg(@Body MultipartBody media) throws WeMpException;
}
