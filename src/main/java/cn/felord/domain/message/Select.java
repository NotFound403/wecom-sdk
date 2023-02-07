package cn.felord.domain.message;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2021/11/25
 */
@Data
public class Select {
    private final String questionKey;
    private final List<Option> optionList;
    private   String title;
    private   String selectedId;
}
