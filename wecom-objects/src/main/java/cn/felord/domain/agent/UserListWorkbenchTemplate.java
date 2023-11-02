package cn.felord.domain.agent;

import cn.felord.enumeration.WorkbenchType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type List workbench template.
 *
 * @author dax
 * @since 2023 /10/25
 */
@ToString
@Getter
public class UserListWorkbenchTemplate extends UserWorkbenchTemplate {
    private final Items items;

    @JsonCreator
    public UserListWorkbenchTemplate(@JsonProperty("agentid") String agentid,
                                     @JsonProperty("userid") String userid,
                                     @JsonProperty("items") Items items) {
        super(agentid, userid, WorkbenchType.LIST);
        this.items = items;
    }
}
