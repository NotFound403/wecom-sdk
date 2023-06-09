package cn.felord.domain.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author dax
 * @since 2023/6/9 15:13
 */
@Data
public class ApprovalThirdNo {
    @JsonProperty("thirdNo")
    private final String thirdNo;
}
