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
public class ListWorkbenchTemplate extends WorkbenchTemplate {
    private final Items items;

    /**
     * Instantiates a new List workbench template.
     *
     * @param agentid the agentid
     * @param items   the items
     */
    public ListWorkbenchTemplate(String agentid, Items items) {
        this(agentid, false, items);
    }

    /**
     * Instantiates a new List workbench template.
     *
     * @param agentid         the agentid
     * @param replaceUserData the replace user data
     * @param items           the items
     */
    @JsonCreator
    public ListWorkbenchTemplate(@JsonProperty("agentid") String agentid,
                                 @JsonProperty("replace_user_data") boolean replaceUserData,
                                 @JsonProperty("items") Items items) {
        super(agentid, replaceUserData, WorkbenchType.LIST);
        this.items = items;
    }
}
