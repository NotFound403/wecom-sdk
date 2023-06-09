package cn.felord.api;

import cn.felord.domain.GenericResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

import java.util.List;

/**
 * 获取企业微信服务器IP
 *
 * @author felord.cn
 * @since 2021 /9/11
 */
public interface DomainApi {


    /**
     * 获取企业微信API域名IP段
     *
     * @return the contact list
     */
    @GET("get_api_domain_ip")
    Single<GenericResponse<List<String>>> getApiDomainIp();

    /**
     * 获取企业微信服务器的ip段
     *
     * @return the api domain ip
     */
    @GET("getcallbackip")
    Single<GenericResponse<List<String>>> getCallbackIp();
}
