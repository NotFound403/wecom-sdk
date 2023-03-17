package cn.felord.domain.wedoc.form;

import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/3/16 13:36
 */
@Data
public class SubmitUser {
    private String userid;
    private Instant submitTime;
    private Long answerId;
    private String userName;
}
