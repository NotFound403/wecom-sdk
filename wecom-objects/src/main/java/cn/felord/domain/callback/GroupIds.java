package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

/**
 * The type Group ids.
 *
 * @author dax
 * @since 2023 /10/13
 */
@ToString
@Getter
public class GroupIds {
    @XStreamImplicit(itemFieldName = "GroupId")
    private final List<Integer> groupIds;

    /**
     * Instantiates a new Group ids.
     *
     * @param groupIds the group ids
     */
    public GroupIds(Integer... groupIds) {
        this.groupIds = Arrays.asList(groupIds);
    }
}
