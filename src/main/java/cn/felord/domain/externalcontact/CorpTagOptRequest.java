package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author dax
 * @since 2021/7/13 11:35
 */
@Data
public class CorpTagOptRequest {
    private final String userid;
    private final String externalUserid;
    private Set<String> addTag;
    private List<String> removeTag;


    public CorpTagOptRequest(String userid, String externalUserid, Set<String> addTag) {
        this(userid, externalUserid, addTag, null);
    }

    public CorpTagOptRequest(String userid, String externalUserid, List<String> removeTag) {
        this(userid, externalUserid, null, removeTag);
    }

    public CorpTagOptRequest(String userid, String externalUserid, Set<String> addTag, List<String> removeTag) {
        this.userid = userid;
        this.externalUserid = externalUserid;
        this.addTag = addTag;
        this.removeTag = removeTag;
    }
}
