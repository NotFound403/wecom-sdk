package cn.felord.domain.approval;

import cn.felord.enumeration.ApprovalCtrlType;
import cn.felord.enumeration.BoolEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author dax
 * @since 2023/10/14
 */
public class WedriveFileApplyContentData extends ApplyContentData<WedriveFileValue> {
    /**
     * Instantiates a new Apply content data.
     *
     * @param control the control
     * @param id      the id
     * @param title   the title
     * @param value   the value
     * @param hidden  the hidden
     * @param require the require
     */
    @JsonCreator
    WedriveFileApplyContentData(@JsonProperty("control") ApprovalCtrlType control,
                                @JsonProperty("id") String id,
                                @JsonProperty("title") List<ApprovalTitle> title,
                                @JsonProperty("value") WedriveFileValue value,
                                @JsonProperty("hidden") Integer hidden,
                                @JsonProperty("require") BoolEnum require) {
        super(control, id, title, value, hidden, require);
    }
}
