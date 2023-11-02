package cn.felord.domain.agent;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The type Agent menu btns.
 *
 * @author dax
 * @since 2023 /10/25
 */
@ToString
@Getter
public class AgentMenuBtns {
    private final List<AgentMenuBtn> button;

    /**
     * Instantiates a new Agent menu btns.
     *
     * @param button the button
     */
    AgentMenuBtns(List<AgentMenuBtn> button) {
        this.button = button;
    }

    /**
     * From agent menu btns.
     *
     * @param button the button
     * @return the agent menu btns
     */
    public static AgentMenuBtns from(List<AgentMenuBtn> button) {
        return new AgentMenuBtns(button);
    }
}
