package cn.felord.domain.externalcontact;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

/**
 * @author dax
 * @since 2021/7/12 16:52
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CorpTag extends CorpTagBase {
    private String id;
    private Instant createTime;
    private Boolean deleted;
}
