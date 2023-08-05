package cn.felord.domain.wedoc.form;

import cn.felord.enumeration.TextValidationDetail;
import cn.felord.enumeration.TextValidationType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * Form文本额外校验
 *
 * @author dax
 * @since 2023 /8/4 11:46
 */
@ToString
@Getter
public class TextSetting {
    private final TextValidationType validationType;
    private TextValidationDetail validationDetail;
    private Integer charLen;
    private Long numberMin;
    private Long numberMax;


    /**
     * Instantiates a new Text setting.
     *
     * @param validationType the validation type
     */
    @JsonCreator
    public TextSetting(@JsonProperty("validation_type") TextValidationType validationType) {
        this.validationType = validationType;
    }

    /**
     * Validation detail text setting.
     *
     * @param validationDetail the validation detail
     * @return the text setting
     */
    public TextSetting validationDetail(TextValidationDetail validationDetail) {
        this.validationDetail = validationDetail;
        return this;
    }

    /**
     * Char len text setting.
     *
     * @param charLen the char len
     * @return the text setting
     */
    public TextSetting charLen(int charLen) {
        this.charLen = charLen;
        return this;
    }

    /**
     * Number min text setting.
     *
     * @param numberMin the number min
     * @return the text setting
     */
    public TextSetting numberMin(long numberMin) {
        this.numberMin = numberMin;
        return this;
    }

    /**
     * Number max text setting.
     *
     * @param numberMax the number max
     * @return the text setting
     */
    public TextSetting numberMax(long numberMax) {
        this.numberMax = numberMax;
        return this;
    }
}
