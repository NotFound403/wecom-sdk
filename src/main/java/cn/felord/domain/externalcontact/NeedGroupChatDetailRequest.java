package cn.felord.domain.externalcontact;

/**
 * @author dax
 * @since 2021/7/15 17:50
 */
public class NeedGroupChatDetailRequest extends GroupChatDetailRequest {
    public NeedGroupChatDetailRequest(String chatId) {
        super(chatId, 1);
    }
}
