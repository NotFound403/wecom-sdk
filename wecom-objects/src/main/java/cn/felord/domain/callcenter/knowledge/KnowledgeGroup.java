package cn.felord.domain.callcenter.knowledge;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Knowledge group.
 *
 * @author dax
 * @since 2023 /10/5
 */
@ToString
@Getter
public class KnowledgeGroup {
    private final String groupId;
    private final String name;

    /**
     * Instantiates a new Knowledge group.
     *
     * @param groupId the group id
     * @param name    the name
     */
    @JsonCreator
    public KnowledgeGroup(@JsonProperty("group_id") String groupId, @JsonProperty("name") String name) {
        this.groupId = groupId;
        this.name = name;
    }
}
