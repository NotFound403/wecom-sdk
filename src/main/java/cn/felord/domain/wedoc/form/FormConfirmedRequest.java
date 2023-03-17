package cn.felord.domain.wedoc.form;

import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/3/16 13:42
 */
@Data
public class FormConfirmedRequest {
    private final String repeatedId;
    private final Integer reqType = 2;
    private final Instant startTime;
    private final Instant endTime;
    private final Integer limit;
    private Long cursor;
}
