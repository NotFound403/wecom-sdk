package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author dax
 * @since 2023/5/25 15:15
 */
@Data
public class EmptyConfig {
    @JsonIgnore
    private String value;
}
