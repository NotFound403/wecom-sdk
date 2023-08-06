package cn.felord.domain.hr;

import cn.felord.enumeration.ValueResult;
import cn.felord.enumeration.ValueType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Field detail.
 *
 * @author dax
 * @since 2023 /8/3 11:35
 */
@EqualsAndHashCode
@ToString
@Getter
public class FieldDetail {
    private final Integer fieldid;
    private final Integer subIdx;
    private final ValueResult result;
    private final ValueType valueType;
    private final String valueString;
    private final Long valueUint64;
    private final Long valueUint32;
    private final Long valueInt64;
    private final ValueMobile valueMobile;
    private final ValueFile valueFile;

    /**
     * Instantiates a new Field detail.
     *
     * @param fieldid     the fieldid
     * @param subIdx      the sub idx
     * @param result      the result
     * @param valueType   the value type
     * @param valueString the value string
     * @param valueUint64 the value uint 64
     * @param valueUint32 the value uint 32
     * @param valueInt64  the value int 64
     * @param valueMobile the value mobile
     * @param valueFile   the value file
     */
    public FieldDetail(@JsonProperty("fieldid") Integer fieldid,
                       @JsonProperty("sub_idx") Integer subIdx,
                       @JsonProperty("result") ValueResult result,
                       @JsonProperty("value_type") ValueType valueType,
                       @JsonProperty("value_string") String valueString,
                       @JsonProperty("value_uint64") Long valueUint64,
                       @JsonProperty("value_uint32") Long valueUint32,
                       @JsonProperty("value_int64") Long valueInt64,
                       @JsonProperty("value_mobile") ValueMobile valueMobile,
                       @JsonProperty("value_file") ValueFile valueFile) {
        this.fieldid = fieldid;
        this.subIdx = subIdx;
        this.result = result;
        this.valueType = valueType;
        this.valueString = valueString;
        this.valueUint64 = valueUint64;
        this.valueUint32 = valueUint32;
        this.valueInt64 = valueInt64;
        this.valueMobile = valueMobile;
        this.valueFile = valueFile;
    }
}