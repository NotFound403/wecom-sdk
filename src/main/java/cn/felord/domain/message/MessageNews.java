package cn.felord.domain.message;

import lombok.Data;

import java.util.List;

/**
 * @author felord
 * @since 2022/11/22 17:23
 */
@Data
public class MessageNews<T extends MessageArticle> {
    private final List<T> articles;
}
