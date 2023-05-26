package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

/**
 * @author xiafang
 * @since 2023/5/25 15:15
 */
@Data
@JsonTypeName("EmptyConfig")
public class EmptyConfig {
    @JsonIgnore
    private String value;
}
