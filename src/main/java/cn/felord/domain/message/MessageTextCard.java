package cn.felord.domain.message;

import lombok.Getter;

/**
 * @author felord
 * @since 2021/11/22 17:14
 */
@Getter
public class MessageTextCard {
    private final String title;
    private final String description;
    private final String url;
    private final String btntxt;

    public MessageTextCard(String title, String description, String url) {
        this(title, description, url, null);
    }

    public MessageTextCard(String title, String description, String url, String btntxt) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.btntxt = btntxt;
    }
}
