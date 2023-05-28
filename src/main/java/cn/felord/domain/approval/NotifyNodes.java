
package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/19 22:23
 */
@Data
public class NotifyNodes {

    @JsonProperty("NotifyNode")
    private List<NotifyNode> notifyNode;

}
