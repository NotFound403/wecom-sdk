package cn.felord.api;

import cn.felord.domain.MediaResponse;
import cn.felord.domain.WeChatMultipartFile;
import cn.felord.domain.WeComResponse;
import cn.felord.domain.webhook.WebhookBody;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * 群机器人
 *
 * @author n1
 * @since 2021 /6/16 19:35
 */
public class WebhookApi {
    private final WorkWeChatApiClient workWeChatApiClient;

    /**
     * Instantiates a new Webhook api.
     */
    WebhookApi() {
        this.workWeChatApiClient = new WorkWeChatApiClient();
    }

    /**
     * 发送机器人信息
     *
     * @param <T>  the type parameter
     * @param key  the key
     * @param body the body
     * @return the we com response
     */
    public <T extends WebhookBody> WeComResponse send(String key, T body) {
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("key", key);
        return workWeChatApiClient.post(WeComEndpoint.WEBHOOK_SEND, query, body, WeComResponse.class);
    }

    /**
     * 上传素材
     *
     * @param media the media
     * @return the media response
     */
    public MediaResponse uploadMedia(String webhookKey, WeChatMultipartFile media) {
        String name = media.getName();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        ContentDisposition contentDisposition = ContentDisposition.builder("form-data")
                .name("media")
                .filename(name)
                .build();
        headers.setContentDisposition(contentDisposition);
        MultiValueMap<Object, Object> body = new LinkedMultiValueMap<>();
        body.add("media", media.getResource());
        LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("key", webhookKey);
        query.add("type", "file");
        return workWeChatApiClient.post(WeComEndpoint.WEBHOOK_UPLOAD, query, body, headers, MediaResponse.class);
    }

}
