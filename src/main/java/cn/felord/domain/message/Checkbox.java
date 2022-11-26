package cn.felord.domain.message;

import cn.felord.enumeration.CheckboxMode;
import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2022/11/25
 */
@Data
public class Checkbox {
    private final String questionKey;
    private final List<Option> optionList;
    private CheckboxMode checkboxMode;

}
