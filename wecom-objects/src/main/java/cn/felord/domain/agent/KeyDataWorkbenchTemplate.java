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
public class KeyDataWorkbenchTemplate extends WorkbenchTemplate {
    private final KeyData keydata;


    /**
     * Instantiates a new Key data workbench template.
     *
     * @param agentid the agentid
     * @param keydata the keydata
     */
    public KeyDataWorkbenchTemplate(String agentid, KeyData keydata) {
        this(agentid, false, keydata);
    }

    /**
     * Instantiates a new Workbench template.
     *
     * @param agentid         the agentid
     * @param replaceUserData the replace user data
     * @param keydata         the keydata
     */
    @JsonCreator
    public KeyDataWorkbenchTemplate(@JsonProperty("agentid") String agentid,
                                    @JsonProperty("replace_user_data") boolean replaceUserData,
                                    @JsonProperty("keydata") KeyData keydata) {
        super(agentid, replaceUserData, WorkbenchType.KEY_DATA);
        this.keydata = keydata;
    }
}
