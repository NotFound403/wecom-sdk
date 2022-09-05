package cn.felord.domain.webhook.card;

/**
 * @author felord.cn
 * @since 2021/9/3 15:38
 */
public class NoneJump extends Jump {
    public NoneJump(String title) {
        super(ClickEventType.NONE, title);
    }
}
