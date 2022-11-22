package cn.felord.domain.message;

import lombok.Data;

/**
 * @author felord
 * @since 2022/11/22 17:14
 */
@Data
public class MessageTextCard {
    private final String title;
    private final String description;
    private final String url;
    private String btntxt;
}
