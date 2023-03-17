package cn.felord.domain.wedoc.form;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dax
 * @since 2023/3/16 13:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FormUnConfirmedResponse extends FormStatisticResponse {
    private List<UnfillUser> unfillUsers;
    private Boolean hasMore;
    private Long cursor;

}
