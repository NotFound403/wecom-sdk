/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.domain.approval;

import cn.felord.enumeration.BoolEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.List;

/**
 * The type Table config.
 *
 * @author dax
 * @since 2024/5/25 16:50
 */
@ToString
@Getter
public class TableConfig implements ControlConfig {
    private final Wrapper table;

    /**
     * Instantiates a new Table config.
     *
     * @param table the table
     */
    @JsonCreator
    TableConfig(@JsonProperty("table") Wrapper table) {
        this.table = table;
    }

    /**
     * From table config.
     *
     * @param children    the children
     * @param printFormat the print format
     * @param statField   the stat field
     * @param sumField    the sum field
     * @return the table config
     */
    public static TableConfig from(@NonNull List<TableCtrlProperty> children, BoolEnum printFormat, List<CtrlProperty> statField, List<CtrlProperty> sumField) {
        return new TableConfig(new Wrapper(children, printFormat, statField, sumField));
    }

    /**
     * From table config.
     *
     * @param children    the children
     * @param printFormat the print format
     * @param statField   the stat field
     * @return the table config
     */
    public static TableConfig from(@NonNull List<TableCtrlProperty> children, BoolEnum printFormat, List<CtrlProperty> statField) {
        return from(children, printFormat, statField, null);
    }

    /**
     * From table config.
     *
     * @param children    the children
     * @param printFormat the print format
     * @return the table config
     */
    public static TableConfig from(@NonNull List<TableCtrlProperty> children, BoolEnum printFormat) {
        return from(children, printFormat, null);
    }

    /**
     * From table config.
     *
     * @param children the children
     * @return the table config
     */
    public static TableConfig from(@NonNull List<TableCtrlProperty> children) {
        return from(children, null);
    }

    /**
     * The type Wrapper.
     */
    @ToString
    @Getter
    public static class Wrapper {
        private final List<TableCtrlProperty> children;
        private final BoolEnum printFormat;
        private final List<CtrlProperty> statField;
        private final List<CtrlProperty> sumField;

        /**
         * Instantiates a new Wrapper.
         *
         * @param children    the children
         * @param printFormat the print format
         * @param statField   the stat field
         * @param sumField    the sum field
         */
        @JsonCreator
        Wrapper(@JsonProperty("children") List<TableCtrlProperty> children,
                @JsonProperty("print_format") BoolEnum printFormat,
                @JsonProperty("stat_field") List<CtrlProperty> statField,
                @JsonProperty("sum_field") List<CtrlProperty> sumField) {
            this.printFormat = printFormat;
            this.children = children;
            this.statField = statField;
            this.sumField = sumField;
        }

    }
}
