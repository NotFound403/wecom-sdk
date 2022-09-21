package cn.felord.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

/**
 * @author n1
 * @since 2021/6/19 10:23
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MediaResponse extends WeComResponse {
    private String type;
    @JsonAlias({"media_id", "url"})
    private String data;
    private Instant createdAt;
}
