
package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
/**
 * @author dax
 * @since 2023/5/19 22:23
 */
@Data
public class ApprovalNode {

    @JsonProperty("Items")
    private Items items;
    @JsonProperty("NodeAttr")
    private Long nodeAttr;
    @JsonProperty("NodeStatus")
    private Long nodeStatus;
    @JsonProperty("NodeType")
    private Long nodeType;
}
