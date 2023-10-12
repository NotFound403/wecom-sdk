package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 关联外部选项
 *
 * @author dax
 * @since 2023 /10/12
 */
@ToString
@Getter
public class ExternalOption {
    /**
     * 是否关联外部选项
     */
    private final Boolean useExternalOption;
    /**
     * 外部选项URL
     */
    private final String externalUrl;

    /**
     * Instantiates a new External option.
     *
     * @param useExternalOption the use external option
     * @param externalUrl       the external url
     */
    @JsonCreator
    public ExternalOption(@JsonProperty("use_external_option") Boolean useExternalOption,
                          @JsonProperty("external_url") String externalUrl) {
        this.useExternalOption = useExternalOption;
        this.externalUrl = externalUrl;
    }
}
