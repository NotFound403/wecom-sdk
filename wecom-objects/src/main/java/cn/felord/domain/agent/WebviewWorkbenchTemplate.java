package cn.felord.domain.agent;

import cn.felord.enumeration.WorkbenchType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Webview workbench template.
 *
 * @author dax
 * @since 2023 /10/25
 */
@ToString
@Getter
public class WebviewWorkbenchTemplate extends WorkbenchTemplate {
    private final Webview webview;

    /**
     * Instantiates a new List workbench template.
     *
     * @param agentid the agentid
     * @param webview the webview
     */
    public WebviewWorkbenchTemplate(String agentid, Webview webview) {
        this(agentid, false, webview);
    }

    /**
     * Instantiates a new List workbench template.
     *
     * @param agentid         the agentid
     * @param replaceUserData the replace user data
     * @param webview         the webview
     */
    @JsonCreator
    public WebviewWorkbenchTemplate(@JsonProperty("agentid") String agentid,
                                    @JsonProperty("replace_user_data") boolean replaceUserData,
                                    @JsonProperty("webview") Webview webview) {
        super(agentid, replaceUserData, WorkbenchType.WEBVIEW);
        this.webview = webview;
    }
}
