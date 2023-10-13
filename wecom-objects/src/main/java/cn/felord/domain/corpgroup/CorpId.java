package cn.felord.domain.corpgroup;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Corp id.
 *
 * @author dax
 * @since 2023 /10/13
 */
@ToString
@Getter
public class CorpId {
    private final String corpid;

    /**
     * Instantiates a new Corp id.
     *
     * @param corpid the corpid
     */
    CorpId(String corpid) {
        this.corpid = corpid;
    }

    /**
     * From corp id.
     *
     * @param corpid the corpid
     * @return the corp id
     */
    public static CorpId from(String corpid) {
        return new CorpId(corpid);
    }
}
