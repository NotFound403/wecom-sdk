package cn.felord.domain.office.form;

import cn.felord.domain.WeComResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xiafang
 * @since 2023/3/16 16:31
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FormAnswerResponse extends WeComResponse {
    private FormAnswer answer;
}
