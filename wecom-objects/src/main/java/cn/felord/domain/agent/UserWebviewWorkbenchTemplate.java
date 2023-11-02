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
public class UserWebviewWorkbenchTemplate extends UserWorkbenchTemplate {
    private final Webview webview;

    @JsonCreator
    public UserWebviewWorkbenchTemplate(@JsonProperty("agentid") String agentid,
                                        @JsonProperty("userid") String userid,
                                        @JsonProperty("webview") Webview webview) {
        super(agentid, userid, WorkbenchType.WEBVIEW);
        this.webview = webview;
    }
}
