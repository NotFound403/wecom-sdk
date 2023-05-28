package cn.felord.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

/**
 * @author dax
 * @since 2023/5/19 22:23
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MediaResponse extends WeComResponse {
    private String type;
    @JsonAlias({"media_id", "url"})
    private String data;
    private Instant createdAt;
}
