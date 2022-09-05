package cn.felord.api;

import cn.felord.AgentDetails;
import cn.felord.Cacheable;
import cn.felord.domain.MediaResponse;
import cn.felord.enumeration.MediaTypeEnum;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

/**
 * The type Media api.
 *
 * @author n1
 * @since 2021 /6/19 9:59
 */
public class MediaApi extends AbstractApi {

    /**
     * Instantiates a new We com client.
     */
    MediaApi(Cacheable cacheable) {
        super(cacheable);
    }

    MediaApi agent(AgentDetails agentDetails) {
        this.withAgent(agentDetails);
        return this;
    }

    /**
     * 上传临时素材
     *
     * @param media     the media
     * @param mediaType the media type
     * @return the media response
     */
    public MediaResponse uploadMedia(MultipartFile media, MediaTypeEnum mediaType) {
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
    public MediaResponse uploadImage(MultipartFile media) {
        String endpoint = WeComEndpoint.MEDIA_UPLOAD_IMG.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint)
                .build()
                .toUri();
        return doUpload(media, uri);
    }

    private MediaResponse doUpload(MultipartFile media, URI uri) {
        String name = Optional.ofNullable(media.getOriginalFilename())
                .orElse(media.getName());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        ContentDisposition contentDisposition = ContentDisposition.builder("form-data")
                .name("media")
                .filename(name)
                .build();
        headers.setContentDisposition(contentDisposition);
        MultiValueMap<Object, Object> body = new LinkedMultiValueMap<>();
        body.add("media", media.getResource());
        return this.post(uri, body, headers, MediaResponse.class);
    }

}
