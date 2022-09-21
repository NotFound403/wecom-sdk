package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.WeComCacheable;
import cn.felord.domain.MediaResponse;
import cn.felord.domain.WeChatMultipartFile;
import cn.felord.enumeration.MediaAttachmentType;
import cn.felord.enumeration.MediaTypeEnum;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * The type Media api.
 *
 * @author n1
 * @since 2021 /6/19 9:59
 */
public class MediaApi extends AbstractApi {

    /**
     * Instantiates a new We com client.
     *
     * @param cacheable the cacheable
     */
    MediaApi(WeComCacheable cacheable) {
        super(cacheable);
    }

    /**
     * Agent media api.
     *
     * @param agentDetails the agent details
     * @return the media api
     */
    MediaApi agent(AgentDetails agentDetails) {
        this.withAgent(agentDetails);
        return this;
    }

    /**
     * Upload attachment media response.
     *
     * @param media     the media
     * @param mediaType the media type
     * @param type      the type
     * @return the media response
     */
    public MediaResponse uploadAttachment(WeChatMultipartFile media, MediaTypeEnum mediaType, MediaAttachmentType type) {
        String endpoint = WeComEndpoint.MEDIA_UPLOAD_ATTACHMENT.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("media_type", mediaType.name().toLowerCase())
                .queryParam("attachment_type", type.getType())
                .build()
                .toUri();
        return doUpload(media, uri);
    }

    /**
     * 上传临时素材
     *
     * @param media     the media
     * @param mediaType the media type
     * @return the media response
     */
    public MediaResponse uploadMedia(WeChatMultipartFile media, MediaTypeEnum mediaType) {
        String endpoint = WeComEndpoint.MEDIA_UPLOAD.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("type", mediaType.name().toLowerCase())
                .build()
                .toUri();
        return doUpload(media, uri);
    }

    /**
     * 上传图片
     *
     * @param media the media
     * @return the media response
     */
    public MediaResponse uploadImage(WeChatMultipartFile media) {
        String endpoint = WeComEndpoint.MEDIA_UPLOAD_IMG.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return doUpload(media, uri);
    }

    private MediaResponse doUpload(WeChatMultipartFile media, URI uri) {
        String name = media.getName();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        ContentDisposition contentDisposition = ContentDisposition.builder("form-data")
                .name("media")
                .filename(name)
                .build();
        headers.setContentDisposition(contentDisposition);
        return this.doUpload(media, headers, uri);
    }

    private MediaResponse doUpload(WeChatMultipartFile media, HttpHeaders headers, URI uri) {

        MultiValueMap<Object, Object> body = new LinkedMultiValueMap<>();
        body.add("media", media.getResource());
        return this.post(uri, body, headers, MediaResponse.class);
    }

}
