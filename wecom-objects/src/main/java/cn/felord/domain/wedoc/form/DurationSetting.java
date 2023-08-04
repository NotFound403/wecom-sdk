package cn.felord.domain.wedoc.form;

import cn.felord.enumeration.DurationDateType;
import cn.felord.enumeration.DurationTimeScale;
import lombok.Data;

/**
 * @author dax
 * @since 2023/8/4 14:37
 */
@Data
public class DurationSetting {
    private DurationTimeScale timeScale;
    private DurationDateType dateType;
    // [1, 24] ，默认为24
    private Integer dayRange;
}
