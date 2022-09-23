package cn.felord.domain.externalcontact;

import lombok.Getter;

import java.util.Collections;
import java.util.Set;

/**
 * @author dax
 * @since 2021/8/13 18:39
 */
@Getter
public class AllCorpTag implements CorpTagIterator {
    private final Set<String> groupId;
    private final Set<String> tagId;

    public AllCorpTag() {
        this.groupId = Collections.emptySet();
        this.tagId = Collections.emptySet();
    }
}
