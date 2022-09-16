package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2021/7/12 16:46
 */
@Data
public class CorpTagIds implements CorpTagIterator {
    private final Set<String> tagId;
}
