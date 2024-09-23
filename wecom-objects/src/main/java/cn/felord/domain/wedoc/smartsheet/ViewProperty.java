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

package cn.felord.domain.wedoc.smartsheet;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

/**
 * The type View property.
 *
 * @author dax
 * @since 2024 /9/2
 */
@ToString
@Getter
public class ViewProperty {
    private Boolean autoSort;
    private SortSpec sortSpec;
    private GroupSpec groupSpec;
    private FilterSpec filterSpec;
    private Boolean isFieldStatEnabled;
    private Map<String, Boolean> fieldVisibility;
    private Integer frozenFieldCount;

    /**
     * Instantiates a new View property.
     */
    public ViewProperty() {
    }

    /**
     * Instantiates a new View property.
     *
     * @param autoSort           the auto sort
     * @param sortSpec           the sort spec
     * @param groupSpec          the group spec
     * @param filterSpec         the filter spec
     * @param isFieldStatEnabled the is field stat enabled
     * @param fieldVisibility    the field visibility
     * @param frozenFieldCount   the frozen field count
     */
    @JsonCreator
    ViewProperty(@JsonProperty("auto_sort") Boolean autoSort,
                 @JsonProperty("sort_spec") SortSpec sortSpec,
                 @JsonProperty("group_spec") GroupSpec groupSpec,
                 @JsonProperty("filter_spec") FilterSpec filterSpec,
                 @JsonProperty("is_field_stat_enabled") Boolean isFieldStatEnabled,
                 @JsonProperty("field_visibility") Map<String, Boolean> fieldVisibility,
                 @JsonProperty("frozen_field_count") Integer frozenFieldCount) {
        this.autoSort = autoSort;
        this.sortSpec = sortSpec;
        this.groupSpec = groupSpec;
        this.filterSpec = filterSpec;
        this.isFieldStatEnabled = isFieldStatEnabled;
        this.fieldVisibility = fieldVisibility;
        this.frozenFieldCount = frozenFieldCount;
    }

    /**
     * Auto sort view property.
     *
     * @param autoSort the auto sort
     * @return the view property
     */
    public ViewProperty autoSort(Boolean autoSort) {
        this.autoSort = autoSort;
        return this;
    }

    /**
     * Sort spec view property.
     *
     * @param sortSpec the sort spec
     * @return the view property
     */
    public ViewProperty sortSpec(SortSpec sortSpec) {
        this.sortSpec = sortSpec;
        return this;
    }

    /**
     * Group spec view property.
     *
     * @param groupSpec the group spec
     * @return the view property
     */
    public ViewProperty groupSpec(GroupSpec groupSpec) {
        this.groupSpec = groupSpec;
        return this;
    }

    /**
     * Filter spec view property.
     *
     * @param filterSpec the filter spec
     * @return the view property
     */
    public ViewProperty filterSpec(FilterSpec filterSpec) {
        this.filterSpec = filterSpec;
        return this;
    }

    /**
     * Field stat enabled view property.
     *
     * @param fieldStatEnabled the field stat enabled
     * @return the view property
     */
    public ViewProperty fieldStatEnabled(Boolean fieldStatEnabled) {
        isFieldStatEnabled = fieldStatEnabled;
        return this;
    }

    /**
     * Field visibility view property.
     *
     * @param fieldVisibility the field visibility
     * @return the view property
     */
    public ViewProperty fieldVisibility(Map<String, Boolean> fieldVisibility) {
        this.fieldVisibility = fieldVisibility;
        return this;
    }

    /**
     * Frozen field count view property.
     *
     * @param frozenFieldCount the frozen field count
     * @return the view property
     */
    public ViewProperty frozenFieldCount(Integer frozenFieldCount) {
        this.frozenFieldCount = frozenFieldCount;
        return this;
    }
}
