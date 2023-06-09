package cn.felord.domain.wedoc.form;

import lombok.Data;

/**
 * @author dax
 * @since 2023/5/24 14:59
 */
@Data
public class FormStatisticRequest {
    private final String repeatedId;
    private final int req_type = 1;
}
