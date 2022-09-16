package cn.felord.domain.externalcontact;

import lombok.Getter;

import java.util.Set;

/**
 * @author dax
 * @since 2021/7/13 11:37
 */
@Getter
public class CorpTagRemoveMarkRequest extends CorpTagOptRequest {
   private final Set<String> removeTag;

    public CorpTagRemoveMarkRequest(String userid, String externalUserid, Set<String> removeTag) {
        super(userid, externalUserid);
        this.removeTag = removeTag;
    }
}
