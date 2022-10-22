package cn.felord.domain.externalcontact;

import cn.felord.enumeration.ContactUserTagType;
import lombok.Data;

/**
 * @author dax
 * @since 2021/7/8 18:30
 */
@Data
public class ExternalContactTag {
    private String groupName;
    private String tagName;
    private String tagId;
    private ContactUserTagType type;
}
