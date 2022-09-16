package cn.felord.domain.externalcontact;

import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author dax
 * @since 2021/7/12 16:50
 */
@Data
public class CorpTagGroup {
    private String groupId;
    private String groupName;
    private Instant createTime;
    private Integer order;
    private Boolean deleted;
    private List<CorpTag> tag;
}
