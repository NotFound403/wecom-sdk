package cn.felord.domain.message;

import lombok.Data;

import java.util.List;

/**
 * The type Button selection.
 *
 * @author felord
 * @since 2021 /11/23 16:09
 */
@Data
public class ButtonSelection {
    private final String questionKey;
    private final List<BtnOption> optionList;
    private String title;
    private String selectedId;


    /**
     * The type Btn option.
     */
    @Data
    public static class BtnOption {
        private final String id;
        private final String text;
    }
}
