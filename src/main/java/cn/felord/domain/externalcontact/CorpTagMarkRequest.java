package cn.felord.domain.externalcontact;

import lombok.Getter;

import java.util.Set;

/**
 * @author dax
 * @since 2021/7/13 11:37
 */
@Getter
public class CorpTagMarkRequest extends CorpTagOptRequest {
   private final Set<String> addTag;

    public CorpTagMarkRequest(String userid, String externalUserid, Set<String> addTag) {
        super(userid, externalUserid);
        this.addTag = addTag;
    }
}
