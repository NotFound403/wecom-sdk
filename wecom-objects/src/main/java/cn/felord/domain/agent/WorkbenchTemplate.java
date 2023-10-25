package cn.felord.domain.agent;

import cn.felord.enumeration.WorkbenchType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.ToString;

/**
 * 工作台
 *
 * @author dax
 * @since 2023 /10/25
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = WorkbenchTemplate.class, name = "normal"),
        @JsonSubTypes.Type(value = KeyDataWorkbenchTemplate.class, name = "keydata"),
        @JsonSubTypes.Type(value = ImageWorkbenchTemplate.class, name = "image"),
        @JsonSubTypes.Type(value = ListWorkbenchTemplate.class, name = "list"),
        @JsonSubTypes.Type(value = WebviewWorkbenchTemplate.class, name = "webview")
})
@ToString
@Getter
public class WorkbenchTemplate {
    private final String agentid;
    private final boolean replaceUserData;
    private final WorkbenchType type;

    /**
     * Instantiates a new Workbench template.
     *
     * @param agentid         the agentid
     * @param replaceUserData the replace user data
     * @param type            the type
     */
    @JsonCreator
    WorkbenchTemplate(@JsonProperty("agentid") String agentid,
                      @JsonProperty("replace_user_data") boolean replaceUserData,
                      @JsonProperty("type") WorkbenchType type) {
        this.agentid = agentid;
        this.replaceUserData = replaceUserData;
        this.type = type;
    }

    /**
     * 切换为普通模式专用
     *
     * @param agentid         the agentid
     * @param replaceUserData the replace user data
     * @return the workbench template
     */
    public static WorkbenchTemplate normal(String agentid, boolean replaceUserData) {
        return new WorkbenchTemplate(agentid, replaceUserData, WorkbenchType.NORMAL);
    }

}
