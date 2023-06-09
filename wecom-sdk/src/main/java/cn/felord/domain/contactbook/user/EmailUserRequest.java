package cn.felord.domain.contactbook.user;

import cn.felord.enumeration.EmailType;
import lombok.Getter;

/**
 * The type Email user request.
 *
 * @author dax
 * @since 2023 /5/24 10:32
 */
@Getter
public class EmailUserRequest {
    private final String email;
    private final int emailType;

    /**
     * Instantiates a new Email user request.
     *
     * @param email     the email
     * @param emailType the email type
     */
    public EmailUserRequest(String email, EmailType emailType) {
        this.email = email;
        this.emailType = emailType.type();
    }
}
