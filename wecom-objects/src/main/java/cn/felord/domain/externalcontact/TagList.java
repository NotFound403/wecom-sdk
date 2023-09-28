package cn.felord.domain.externalcontact;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;

/**
 * The type Tag list.
 *
 * @author dax
 * @since 2023 /9/28
 */
@ToString
@Getter
public class TagList {
    private final Set<String> tagList;

    /**
     * Instantiates a new Tag list.
     *
     * @param tagList the tag list
     */
    TagList(Set<String> tagList) {
        this.tagList = tagList;
    }
}
