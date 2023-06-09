package cn.felord.domain.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dax
 * @since 2023/5/24 15:55
 */
@ToString
@Getter
public class UserId {
    private final String userid;

    @JsonCreator
    public UserId(@JsonProperty("userid") String userid) {
        this.userid = userid;
    }
}
