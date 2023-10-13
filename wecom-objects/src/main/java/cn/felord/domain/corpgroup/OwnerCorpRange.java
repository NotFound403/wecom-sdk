package cn.felord.domain.corpgroup;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Owner corp range.
 *
 * @author dax
 * @since 2023 /10/13
 */
@ToString
@Getter
public class OwnerCorpRange {
    private final List<String> userids;
    private final List<String> departmentids;

    /**
     * Instantiates a new Owner corp range.
     *
     * @param userids       the userids
     * @param departmentids the departmentids
     */
    @JsonCreator
    OwnerCorpRange(@JsonProperty("userids") List<String> userids,
                   @JsonProperty("departmentids") List<String> departmentids) {
        this.userids = userids;
        this.departmentids = departmentids;
    }

    /**
     * Both owner corp range.
     *
     * @param userids       the userids
     * @param departmentids the departmentids
     * @return the owner corp range
     */
    public static OwnerCorpRange both(List<String> userids, List<String> departmentids) {
        return new OwnerCorpRange(userids, departmentids);
    }

    /**
     * User ids owner corp range.
     *
     * @param userids the userids
     * @return the owner corp range
     */
    public static OwnerCorpRange userIds(List<String> userids) {
        return new OwnerCorpRange(userids, null);
    }

    /**
     * Departmentids owner corp range.
     *
     * @param departmentids the departmentids
     * @return the owner corp range
     */
    public static OwnerCorpRange departmentIds(List<String> departmentids) {
        return new OwnerCorpRange(null, departmentids);
    }
}