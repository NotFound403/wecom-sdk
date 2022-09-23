package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.Set;

/**
 * @author xiafang
 * @since 2022/9/23 9:35
 */
@Data
public class WelcomeCodeRequest {
    private final String welcomeCode;
    private Text text;
    private Set<? extends MsgAttachment> attachments;
}
