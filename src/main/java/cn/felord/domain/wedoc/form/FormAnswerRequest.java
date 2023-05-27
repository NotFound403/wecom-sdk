package cn.felord.domain.wedoc.form;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

/**
 * @author dax
 * @since 2023/3/16 16:34
 */
@AllArgsConstructor
@Getter
public class FormAnswerRequest {
    private final String repeatedId;
    private final Set<Long> answerIds;
}
