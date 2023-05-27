package cn.felord.api;

import cn.felord.RestTemplateFactory;
import cn.felord.domain.wedrive.FileDownloadResponse;
import cn.felord.enumeration.WeComEndpoint;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.Map;

/**
 * The type File manager api.
 *
 * @author dax
 * @since 2023 /3/17 15:02
 */
public class FileManagerApi {
    private final WorkWeChatApiClient workWeChatApiClient;
    private final RestTemplate restTemplate = RestTemplateFactory.restOperations();

    /**
     * Instantiates a new File manager api.
     *
     * @param workWeChatApiClient the work we chat api client
     */
    FileManagerApi(WorkWeChatApiClient workWeChatApiClient) {
        this.workWeChatApiClient = workWeChatApiClient;
    }

    /**
     * 下载文件（通过文件fileid）
     *
     * @param fileid the fileid
     * @return the file download response
     */
    public Resource getFileUrlByFileId(String fileid) {
        return this.getFileUrl(Collections.singletonMap("fileid", fileid));
    }

    /**
     * 下载文件（微盘和文件选择器jsapi返回的selectedTicket）
     *
     * @param selectedTicket the selected ticket
     * @return the file download response
     */
    public Resource getFileUrlBySelectedTicket(String selectedTicket) {
        return this.getFileUrl(Collections.singletonMap("selected_ticket", selectedTicket));
    }

    private Resource getFileUrl(Map<String, String> singletonParamMap) {
        String endpoint = WeComEndpoint.WEDRIVE_FILE_DOWNLOAD.endpoint();
        URI uri = UriComponentsBuilder.fromHttpUrl(endpoint).build().toUri();
        FileDownloadResponse downloadResponse = workWeChatApiClient.post(uri, singletonParamMap, FileDownloadResponse.class);
        String downloadUrl = downloadResponse.getDownloadUrl();
        String cookie = downloadResponse.getCookieName()
                .concat("=")
                .concat(downloadResponse.getCookieValue());
        URI downloadUri = UriComponentsBuilder.fromHttpUrl(downloadUrl).build().toUri();
        RequestEntity<Void> request = RequestEntity.get(downloadUri)
                .header(HttpHeaders.COOKIE, cookie)
                .build();
        ResponseEntity<Resource> fileResponse = this.restTemplate.exchange(request, Resource.class);
        return fileResponse.getBody();

    }
}
