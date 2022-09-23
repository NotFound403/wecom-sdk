package cn.felord.domain.externalcontact;

import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2021/7/12 16:52
 */
@Data
public class CorpTag {
    private String id;
    private String name;
    private Instant createTime;
    private Long order;
    private Boolean deleted;
}
