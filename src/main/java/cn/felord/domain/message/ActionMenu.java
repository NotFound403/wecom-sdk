package cn.felord.domain.message;

import lombok.Data;

import java.util.List;

/**
 * @author felord
 * @since 2022/11/23 11:00
 */
@Data
public class ActionMenu {
    private final List<Action> actionList;
    private String desc;

    @Data
    public static class Action {
        private String text;
        private String key;
    }

}
