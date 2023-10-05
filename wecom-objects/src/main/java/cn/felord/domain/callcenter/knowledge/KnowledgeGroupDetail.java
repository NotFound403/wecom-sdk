package cn.felord.domain.callcenter.knowledge;

import cn.felord.enumeration.BoolEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Knowledge group detail.
 *
 * @author dax
 * @since 2023 /10/5
 */
@ToString
@Getter
public class KnowledgeGroupDetail extends KnowledgeGroup {
    private final BoolEnum isDefault;

    /**
     * Instantiates a new Knowledge group.
     *
     * @param groupId   the group id
     * @param name      the name
     * @param isDefault the is default
     */
    @JsonCreator
    public KnowledgeGroupDetail(@JsonProperty("group_id") String groupId,
                                @JsonProperty("name") String name,
                                @JsonProperty("is_default") BoolEnum isDefault) {
        super(groupId, name);
        this.isDefault = isDefault;
    }
}
