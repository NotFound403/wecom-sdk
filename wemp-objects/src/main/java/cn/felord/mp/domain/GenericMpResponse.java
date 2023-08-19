package cn.felord.mp.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dax
 * @since 2023/8/19
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GenericMpResponse<T> extends MpResponse {
    @JsonAlias({"code", "cardId"})
    private T data;
}
