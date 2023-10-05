package cn.felord.domain.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Group id.
 *
 * @author dax
 * @since 2023 /10/5
 */
@ToString
@Getter
public class GroupId {
    private final String groupId;

    /**
     * Instantiates a new Group id.
     *
     * @param groupId the group id
     */
    @JsonCreator
    public GroupId(@JsonProperty("group_id") String groupId) {
        this.groupId = groupId;
    }
}