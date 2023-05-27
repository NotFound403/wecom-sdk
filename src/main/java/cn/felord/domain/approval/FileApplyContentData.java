package cn.felord.domain.approval;

import cn.felord.enumeration.ApprovalCtrlType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/27
 */
public class FileApplyContentData extends ApplyContentData<FileValue> {
    @JsonCreator
    public FileApplyContentData(@JsonProperty("control") ApprovalCtrlType control,
                                @JsonProperty("id") String id,
                                @JsonProperty("title") List<ApprovalTitle> title,
                                @JsonProperty("value") FileValue value,
                                @JsonProperty("hidden") Integer hidden) {
        super(control, id, title, value, hidden);
    }
}
