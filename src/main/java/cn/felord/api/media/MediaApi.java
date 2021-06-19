package cn.felord.api.media;

import cn.felord.AgentDetails;
import cn.felord.api.AbstractApi;
import cn.felord.domain.MediaResponse;
import cn.felord.domain.WeComResponse;
import cn.felord.enumeration.MediaTypeEnum;
import cn.felord.enumeration.WeComDomain;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.Objects;

/**
 * The type Media api.
 *
 * @author n1
 * @since 2021 /6/19 9:59
 */
public class MediaApi extends AbstractApi {

    /**
     * Instantiates a new Media api.
     *
     * @param agentDetails the agent details
     */
    public MediaApi(AgentDetails agentDetails) {
        super(agentDetails);
    }

    /**
     * 上传临时素材
     *
     * @param media     the media
     * @param mediaType the media type
     * @return the media response
     */
    public MediaResponse uploadMedia(MultipartFile media, MediaTypeEnum mediaType) {
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.MEDIA_UPLOAD.endpoint(WeComDomain.CGI_BIN))
                .queryParam("type", mediaType.name().toLowerCase())
                .build()
                .toUri();
        return doUpload(media, "media", uri);
    }

    /**
     * 上传临时素材
     *
     * @param media the media
     * @return the media response
     */
    public MediaResponse uploadMedia(MultipartFile media) {
        URI uri = UriComponentsBuilder.fromHttpUrl(WeComEndpoint.MEDIA_UPLOAD_IMG.endpoint(WeComDomain.CGI_BIN))
                .build()
                .toUri();
        return doUpload(media, media.getName(), uri);
    }

    private <T extends WeComResponse> T doUpload(MultipartFile media, String name, URI uri) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.MULTIPART_FORM_DATA));
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setContentDisposition(ContentDisposition.formData()
                .name(name)
                .filename(Objects.requireNonNull(media.getOriginalFilename()))
                .build());
        MultiValueMap<Object, Object> body = new LinkedMultiValueMap<>();
        body.add(name, media.getOriginalFilename());
        return this.weComClient().post(uri, body, headers, new ParameterizedTypeReference<T>() {
        });
    }

}
