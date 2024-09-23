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

package cn.felord.domain.wedoc.doc;

import cn.felord.enumeration.SheetUpdateEvent;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

/**
 * @author dax
 * @since 2024/8/16
 */
@ToString
@Getter
public class SheetUpdateResponse {
    private final AddSheetResponse addSheetResponse;
    private final UpdateRangeResponse updateRangeResponse;
    private final DeleteDimensionResponse deleteDimensionResponse;
    private final SheetId deleteSheetResponse;
    private final SheetUpdateEvent event;


    @JsonCreator
    SheetUpdateResponse(@JsonProperty("add_sheet_response") AddSheetResponse addSheetResponse,
                        @JsonProperty("update_range_response") UpdateRangeResponse updateRangeResponse,
                        @JsonProperty("delete_dimension_response") DeleteDimensionResponse deleteDimensionResponse,
                        @JsonProperty("delete_sheet_response") SheetId deleteSheetResponse) {
        this.addSheetResponse = addSheetResponse;
        this.updateRangeResponse = updateRangeResponse;
        this.deleteDimensionResponse = deleteDimensionResponse;
        this.deleteSheetResponse = deleteSheetResponse;
        this.event = this.event(addSheetResponse, updateRangeResponse, deleteDimensionResponse, deleteSheetResponse);
    }

    private SheetUpdateEvent event(AddSheetResponse addSheetResponse,
                                   UpdateRangeResponse updateRangeResponse,
                                   DeleteDimensionResponse deleteDimensionResponse,
                                   SheetId deleteSheetResponse) {
        if (Objects.nonNull(addSheetResponse)) {
            return SheetUpdateEvent.ADD_SHEET;
        } else if (Objects.nonNull(updateRangeResponse)) {
            return SheetUpdateEvent.UPDATE_RANGE;
        } else if (Objects.nonNull(deleteDimensionResponse)) {
            return SheetUpdateEvent.DELETE_DIMENSION;
        } else if (Objects.nonNull(deleteSheetResponse)) {
            return SheetUpdateEvent.DELETE_SHEET;
        }
        return SheetUpdateEvent.ERROR;
    }

}
