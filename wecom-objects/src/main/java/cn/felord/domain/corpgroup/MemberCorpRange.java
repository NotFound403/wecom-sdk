package cn.felord.domain.corpgroup;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Member corp range.
 *
 * @author dax
 * @since 2023 /10/13
 */
@ToString
@Getter
public class MemberCorpRange {
    private final List<String> corpids;
    private final List<String> groupids;


    /**
     * Instantiates a new Member corp range.
     *
     * @param corpids  the corpids
     * @param groupids the groupids
     */
    @JsonCreator
    MemberCorpRange(@JsonProperty("corpids") List<String> corpids,
                    @JsonProperty("groupids") List<String> groupids) {
        this.corpids = corpids;
        this.groupids = groupids;
    }

    public static OwnerCorpRange both(List<String> corpids, List<String> groupids) {
        return new OwnerCorpRange(corpids, groupids);
    }

    /**
     * User ids owner corp range.
     *
     * @param corpids the corpids
     * @return the owner corp range
     */
    public static OwnerCorpRange corpIds(List<String> corpids) {
        return new OwnerCorpRange(corpids, null);
    }

    /**
     * groupids owner corp range.
     *
     * @param groupids the groupids
     * @return the owner corp range
     */
    public static OwnerCorpRange groupIds(List<String> groupids) {
        return new OwnerCorpRange(null, groupids);
    }
}