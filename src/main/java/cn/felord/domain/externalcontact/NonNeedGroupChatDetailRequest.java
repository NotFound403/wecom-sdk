package cn.felord.domain.externalcontact;

/**
 * @author dax
 * @since 2021/7/15 17:51
 */
public class NonNeedGroupChatDetailRequest extends GroupChatDetailRequest {
    public NonNeedGroupChatDetailRequest(String chatId) {
        super(chatId, 0);
    }
}
