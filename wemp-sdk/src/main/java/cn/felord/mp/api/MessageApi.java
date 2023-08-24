package cn.felord.mp.api;

import cn.felord.mp.domain.message.MessageBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author dax
 * @since 2023/8/24
 */

public interface MessageApi {

    @POST("cgi-bin/message/template/send")
    ResponseBody send(@Body MessageBody body);
}
