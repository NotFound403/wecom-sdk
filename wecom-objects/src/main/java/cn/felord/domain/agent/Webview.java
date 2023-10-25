package cn.felord.domain.agent;

import lombok.Data;

/**
 * The type Webview.
 *
 * @author dax
 * @since 2023 /10/25
 */
@Data
public class Webview implements WorkBenchBody {
    private String pagepath;
    private String jumpUrl;
    private Boolean hideTitle;
    private Boolean enableWebviewClick;
    private String url;
    private String height;
}