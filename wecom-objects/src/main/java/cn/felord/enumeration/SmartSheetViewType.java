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

package cn.felord.enumeration;

/**
 * 智能表格视图类型
 *
 * @author dax
 * @since 2024/9/2
 */
public enum SmartSheetViewType {

    /**
     * 未知类型视图，传递该值不合法
     */
    VEW_UNKNOWN,
    /**
     * 网格视图
     */
    VIEW_TYPE_GRID,
    /**
     * 看板视图
     */
    VIEW_TYPE_KANBAN,
    /**
     * 画册视图
     */
    VIEW_TYPE_GALLERY,
    /**
     * 甘特视图
     */
    VIEW_TYPE_GANTT,
    /**
     * 日历视图
     */
    VIEW_TYPE_CALENDAR
}
