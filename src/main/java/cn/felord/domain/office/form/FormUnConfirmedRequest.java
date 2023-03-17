package cn.felord.domain.office.form;

import lombok.Data;

/**
 * @author dax
 * @since 2023/3/16 13:42
 */
@Data
public class FormUnConfirmedRequest {
    private final String repeatedId;
    private final Integer reqType = 3;
    private Integer limit;
    private Long cursor;
}
