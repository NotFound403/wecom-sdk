package cn.felord.domain.corpgroup;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;

/**
 * The type Ex pending id request.
 *
 * @author dax
 * @since 2023 /10/12
 */
@ToString
@Getter
public class ExPendingIdRequest {
    private final Set<String> externalUserid;
    private String chatId;

    /**
     * Instantiates a new Ex pending id request.
     *
     * @param externalUserid the external userid
     */
    public ExPendingIdRequest(Set<String> externalUserid) {
        this.externalUserid = externalUserid;
    }

    /**
     * Chat id ex pending id request.
     *
     * @param chatId the chat id
     * @return the ex pending id request
     */
    public ExPendingIdRequest chatId(String chatId) {
        this.chatId = chatId;
        return this;
    }
}