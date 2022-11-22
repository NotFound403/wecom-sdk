package cn.felord.domain.message;

import lombok.Data;

/**
 * @author felord
 * @since 2022/11/22 16:44
 */
@Data
public class MessageVideo {
    private final String mediaId;
    private String title;
    private String description;
}
