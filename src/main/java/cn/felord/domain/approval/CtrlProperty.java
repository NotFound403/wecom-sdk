package cn.felord.domain.approval;

import cn.felord.enumeration.ApprovalCtrlType;
import cn.felord.enumeration.BoolEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author xiafang
 * @since 2023/5/25 14:44
 */
@Data
public class CtrlProperty {
    private final ApprovalCtrlType control;
    private final String id;
    private final List<ApprovalTitle> title;
    private List<ApprovalTitle> placeholder;
    private BoolEnum require;
    private BoolEnum unPrint;

    @JsonCreator
    public CtrlProperty(@JsonProperty("control") ApprovalCtrlType control,
                        @JsonProperty("id") String id,
                        @JsonProperty("title") List<ApprovalTitle> title) {
        this.control = control;
        this.id = id;
        this.title = title;
    }
}
