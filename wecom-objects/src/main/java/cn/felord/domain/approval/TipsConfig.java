package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Tips config.
 *
 * @author dax
 * @since 2024/1/24
 */
@ToString
@Getter
public class TipsConfig implements ControlConfig {
    private final Tips tips;

    /**
     * Instantiates a new Tips config.
     *
     * @param tips the tips
     */
    @JsonCreator
    TipsConfig(@JsonProperty("tips") Tips tips) {
        this.tips = tips;
    }

    /**
     * Instantiates a new Tips config.
     *
     * @param tipsContent the tips content
     * @see TipsContent#zhCN(List)
     * @see TipsContent#from(String, List)
     */
    public static TipsConfig from(List<TipsContent> tipsContent) {
        return new TipsConfig(new Tips(tipsContent));
    }
}
