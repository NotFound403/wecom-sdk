package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.Set;

/**
 * @author dax
 * @since 2021/7/14 15:27
 */
@Data
public class TransferGroupChatRequest {
    private final Set<String> chatIdList;
    private final String newOwner;
}
