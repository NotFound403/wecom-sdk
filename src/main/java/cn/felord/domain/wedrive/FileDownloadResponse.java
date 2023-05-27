package cn.felord.domain.wedrive;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2023/3/17 15:09
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FileDownloadResponse extends WeComResponse {
    private String downloadUrl;
    private String cookieName;
    private String cookieValue;
}
