package cn.felord.mp.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * @author xiafang
 * @since 2023/8/18 11:15
 */
@Data
public class MpResponse<T> {
    private Integer errcode = 0;
    private String errmsg = "ok";
    @JsonAlias({
            "url"
    })
    private T data;
}
