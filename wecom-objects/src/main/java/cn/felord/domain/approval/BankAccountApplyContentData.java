package cn.felord.domain.approval;

import cn.felord.enumeration.ApprovalCtrlType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The type Bank account apply content data.
 *
 * @author dax
 * @since 2024 /1/20
 */
public class BankAccountApplyContentData extends ApplyContentData<BankAccountValue> {
    /**
     * Instantiates a new Apply content data.
     *
     * @param control the control
     * @param id      the id
     * @param title   the title
     * @param value   the value
     */
    @JsonCreator
    BankAccountApplyContentData(@JsonProperty("control") ApprovalCtrlType control,
                                @JsonProperty("id") String id,
                                @JsonProperty("title") List<ApprovalTitle> title,
                                @JsonProperty("value") BankAccountValue value) {
        super(control, id, title, value);
    }
}
