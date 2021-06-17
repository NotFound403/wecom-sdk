package cn.felord.domain.contactbook.user;

import java.util.List;

import lombok.Data;

/**
 * @author n1
 */
@Data
public class ExternalProfile {
    private List<ExternalAttrItem> externalAttr;
    private String externalCorpName;
}