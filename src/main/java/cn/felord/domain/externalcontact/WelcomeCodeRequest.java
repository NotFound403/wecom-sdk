package cn.felord.domain.externalcontact;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2021/9/23 9:35
 */
@Data
public class WelcomeCodeRequest {
    private final String welcomeCode;
    private Text text;
    private List<? extends MsgAttachment> attachments;
}
