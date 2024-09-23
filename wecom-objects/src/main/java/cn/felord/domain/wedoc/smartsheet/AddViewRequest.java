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

import cn.felord.enumeration.SmartSheetViewType;
import lombok.Getter;
import lombok.ToString;

/**
 * 添加视图
 *
 * @author dax
 * @since 2024 /9/2
 */
@ToString
@Getter
public class AddViewRequest {
    private final String docid;
    private final String sheetId;
    private final String viewTitle;
    private final SmartSheetViewType viewType;
    private final ViewDateRange propertyGantt;
    private final ViewDateRange propertyCalendar;


    /**
     * Instantiates a new Add view request.
     *
     * @param docid            the docid
     * @param sheetId          the sheet id
     * @param viewTitle        the view title
     * @param viewType         the view type
     * @param propertyGantt    the property gantt
     * @param propertyCalendar the property calendar
     */
    AddViewRequest(String docid,
                   String sheetId,
                   String viewTitle,
                   SmartSheetViewType viewType,
                   ViewDateRange propertyGantt,
                   ViewDateRange propertyCalendar) {
        this.docid = docid;
        this.sheetId = sheetId;
        this.viewTitle = viewTitle;
        this.viewType = viewType;
        this.propertyGantt = propertyGantt;
        this.propertyCalendar = propertyCalendar;
    }

    /**
     * Instantiates a new Add view request.
     *
     * @param docid     the docid
     * @param sheetId   the sheet id
     * @param viewTitle the view title
     * @param viewType  the view type
     */
    AddViewRequest(String docid, String sheetId, String viewTitle, SmartSheetViewType viewType) {
        this(docid, sheetId, viewTitle, viewType, null, null);
    }

    /**
     * 网格视图
     *
     * @param docid     the docid
     * @param sheetId   the sheet id
     * @param viewTitle the view title
     * @return the add view request
     */
    public AddViewRequest grid(String docid,
                               String sheetId,
                               String viewTitle) {
        return new AddViewRequest(docid, sheetId, viewTitle, SmartSheetViewType.VIEW_TYPE_GRID);
    }

    /**
     * 看板视图
     *
     * @param docid     the docid
     * @param sheetId   the sheet id
     * @param viewTitle the view title
     * @return add view request
     */
    public AddViewRequest kanban(String docid,
                                 String sheetId,
                                 String viewTitle) {
        return new AddViewRequest(docid, sheetId, viewTitle, SmartSheetViewType.VIEW_TYPE_KANBAN);
    }

    /**
     * 画册视图
     *
     * @param docid     the docid
     * @param sheetId   the sheet id
     * @param viewTitle the view title
     * @return the add view request
     */
    public AddViewRequest gallery(String docid,
                                  String sheetId,
                                  String viewTitle) {
        return new AddViewRequest(docid, sheetId, viewTitle, SmartSheetViewType.VIEW_TYPE_GALLERY);
    }

    /**
     * 甘特视图
     *
     * @param docid         the docid
     * @param sheetId       the sheet id
     * @param viewTitle     the view title
     * @param propertyGantt the property gantt
     * @return the add view request
     */
    public AddViewRequest gantt(String docid,
                                String sheetId,
                                String viewTitle,
                                ViewDateRange propertyGantt) {
        return new AddViewRequest(docid, sheetId, viewTitle, SmartSheetViewType.VIEW_TYPE_GANTT, propertyGantt, null);
    }

    /**
     * 日历视图
     *
     * @param docid            the docid
     * @param sheetId          the sheet id
     * @param viewTitle        the view title
     * @param propertyCalendar the property calendar
     * @return the add view request
     */
    public AddViewRequest calendar(String docid,
                                   String sheetId,
                                   String viewTitle,
                                   ViewDateRange propertyCalendar) {
        return new AddViewRequest(docid, sheetId, viewTitle, SmartSheetViewType.VIEW_TYPE_CALENDAR, null, propertyCalendar);
    }
}
