package cn.felord.domain.message;

import lombok.Data;

import java.util.List;

/**
 * @author felord
 * @since 2022/11/23 8:57
 */
@Data
public class MiniprogramNotice {
    private final String appid;
    private final String title;
    private String page;
    private String description;
    private Boolean emphasisFirstItem;
    private List<KV> contentItem;
}
