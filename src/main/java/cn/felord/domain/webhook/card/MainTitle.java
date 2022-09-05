package cn.felord.domain.webhook.card;

import lombok.Getter;

/**
 * 模板卡片主要内容
 *
 * @author felord.cn
 * @since 2021/9/3 14:28
 */
@Getter
public class MainTitle {
    private final String title;
    private String desc;

    public MainTitle(String title) {
        this.title = title;
    }

    public MainTitle(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }
}
