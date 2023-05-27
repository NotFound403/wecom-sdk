package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/26
 */
@ToString
@Getter
public class ApplyData<T> {
    private final List<T> contents;

    @JsonCreator
    public ApplyData(@JsonProperty("contents") List<T> contents) {
        this.contents = contents;
    }
}
