package cn.felord.mp.api;

import cn.felord.common.MultipartResource;
import cn.felord.mp.WeMpException;
import cn.felord.mp.domain.MpResponse;
import cn.felord.utils.MediaUtil;
import retrofit2.Retrofit;

/**
 * 公众号媒体管理
 *
 * @author xiafang
 * @since 2023 /8/18 9:16
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
     * @return the response body
     * @throws WeMpException the we mp exception
     */
    public MpResponse<String> uploadImg(MultipartResource resource) throws WeMpException {
        return internalMediaApi.uploadImg(MediaUtil.toMultipartBody(resource));
    }
}
