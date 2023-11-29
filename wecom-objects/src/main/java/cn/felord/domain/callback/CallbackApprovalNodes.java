package cn.felord.domain.callback;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/11/29
 */
@Data
public class CallbackApprovalNodes {
    @XStreamImplicit(itemFieldName = "Item")
    private List<OpenApprovalNode> approvalNodes;
}
