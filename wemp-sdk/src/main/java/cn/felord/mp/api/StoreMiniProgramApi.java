package cn.felord.mp.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;

/**
 * 门店小程序接口
 *
 * @author dax
 * @since 2023/8/21
 */
public interface StoreMiniProgramApi {

    @GET("wxa/get_merchant_category")
    ResponseBody getMerchantCategory();
}
