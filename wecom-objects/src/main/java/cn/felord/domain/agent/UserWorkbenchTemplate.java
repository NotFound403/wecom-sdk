package cn.felord.domain.agent;

import cn.felord.enumeration.WorkbenchType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.ToString;

/**
 * 用户工作台
 *
 * @author dax
 * @since 2023 /10/25
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = KeyDataWorkbenchTemplate.class, name = "keydata"),
        @JsonSubTypes.Type(value = ImageWorkbenchTemplate.class, name = "image"),
        @JsonSubTypes.Type(value = ListWorkbenchTemplate.class, name = "list"),
        @JsonSubTypes.Type(value = WebviewWorkbenchTemplate.class, name = "webview")
})
@ToString
@Getter
public class UserWorkbenchTemplate {
    private final String agentid;
    private final String userid;
    private final WorkbenchType type;

    /**
     * Instantiates a new User workbench template.
     *
     * @param agentid the agentid
     * @param userid  the userid
     * @param type    the type
     */
    @JsonCreator
    UserWorkbenchTemplate(@JsonProperty("agentid") String agentid,
                          @JsonProperty("userid") String userid,
                          @JsonProperty("type") WorkbenchType type) {
        this.agentid = agentid;
        this.userid = userid;
        this.type = type;
    }
}
