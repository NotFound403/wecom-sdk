package cn.felord.domain.agent;

import cn.felord.enumeration.WorkbenchType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Key data workbench template.
 *
 * @author dax
 * @since 2023 /10/25
 */
@ToString
@Getter
public class UserKeyDataWorkbenchTemplate extends UserWorkbenchTemplate {
    private final KeyData keydata;

    /**
     * Instantiates a new User key data workbench template.
     *
     * @param agentid the agentid
     * @param userid  the userid
     * @param keydata the keydata
     */
    @JsonCreator
    public UserKeyDataWorkbenchTemplate(@JsonProperty("agentid") String agentid,
                                        @JsonProperty("userid") String userid,
                                        @JsonProperty("keydata") KeyData keydata) {
        super(agentid, userid, WorkbenchType.KEY_DATA);
        this.keydata = keydata;
    }
}
