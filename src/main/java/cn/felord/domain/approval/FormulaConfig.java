package cn.felord.domain.approval;

import lombok.Data;

import java.util.List;

/**
 * 公式配置
 * <p>
 * 示例：{@code {"formula":{"tokens":["Money-26325626","+","Money-93708401","+","Money-78842584","*","2"]}}}
 *
 * @author dax
 * @since 2023 /5/27 8:44
 */
@Data
public class FormulaConfig {
    private Wrapper formula;

    /**
     * The type Wrapper.
     */
    @Data
    public static class Wrapper {
        private List<String> tokens;
    }
}
