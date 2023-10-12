package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 关联控件
 *
 * @author dax
 * @since 2023 /10/12
 */
@ToString
@Getter
public class OpRelation {
    /**
     * 关联控件的控件ID
     */
    private final String relatedControlId;
    /**
     * 固定为1
     */
    private final Integer action;

    /**
     * Instantiates a new Op relation.
     *
     * @param relatedControlId the related control id
     * @param action           the action
     */
    @JsonCreator
    public OpRelation(@JsonProperty("related_control_id") String relatedControlId,
                      @JsonProperty("action") Integer action) {
        this.relatedControlId = relatedControlId;
        this.action = action;
    }
}
