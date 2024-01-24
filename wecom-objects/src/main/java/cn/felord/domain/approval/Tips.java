package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Tips.
 *
 * @author dax
 * @since 2024/1/24
 */
@ToString
@Getter
public class Tips {
    private final List<TipsContent> tipsContent;

    /**
     * Instantiates a new Tips.
     *
     * @param tipsContent the tips content
     */
    @JsonCreator
    Tips(@JsonProperty("tips_content") List<TipsContent> tipsContent) {
        this.tipsContent = tipsContent;
    }
}
