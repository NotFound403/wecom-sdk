/*
 *  Copyright (c) 2023. felord.cn
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  Website:
 *       https://felord.cn
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.felord.domain.approval;

import cn.felord.enumeration.ApprovalCtrlType;
import cn.felord.enumeration.BoolEnum;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 控件类型：Text-文本；Textarea-多行文本；Number-数字；Money-金额；
 *
 * @param <C> the type parameter
 * @author dax
 * @since 2024/5/25 16:00
 */
public final class TmpControlBuilder<C extends ControlConfig> {
    private static final Random RANDOM = new SecureRandom();
    private final ApprovalCtrlType control;
    private final List<ApprovalTitle> title;
    private List<ApprovalTitle> placeholder;
    private BoolEnum require;
    private BoolEnum unPrint;

    /**
     * Instantiates a new Tmp control builder.
     *
     * @param control the control
     * @param title   the title
     */
    TmpControlBuilder(ApprovalCtrlType control, String title) {
        this.control = control;
        this.title = Collections.singletonList(ApprovalTitle.zhCN(title));
    }

    /**
     * 提示语
     *
     * @param placeholder the placeholder
     * @return the tmp control builder
     */
    public TmpControlBuilder<C> placeholder(String placeholder) {
        this.placeholder = Collections.singletonList(ApprovalTitle.zhCN(placeholder));
        return this;
    }

    /**
     * 是否必填
     *
     * @param require the require
     * @return the tmp control builder
     */
    public TmpControlBuilder<C> require(BoolEnum require) {
        this.require = require;
        return this;
    }

    /**
     * 是否不打印
     *
     * @param unPrint the un print
     * @return the tmp control builder
     */
    public TmpControlBuilder<C> unPrint(BoolEnum unPrint) {
        this.unPrint = unPrint;
        return this;
    }

    /**
     * 文本控件
     *
     * @param title the title
     * @return the tmp control builder
     * @see TextValue
     */
    public static TmpControlBuilder<EmptyConfig> text(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.TEXT, title);
    }

    /**
     * 富文本控件
     *
     * @param title the title
     * @return the tmp control builder
     * @see TextValue
     */
    public static TmpControlBuilder<EmptyConfig> textarea(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.TEXTAREA, title);
    }

    /**
     * 数字控件
     *
     * @param title the title
     * @return the tmp control builder
     * @see NumberValue
     */
    public static TmpControlBuilder<EmptyConfig> number(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.NUMBER, title);
    }

    /**
     * 货币控件
     *
     * @param title the title
     * @return the tmp control builder
     * @see MoneyValue
     */
    public static TmpControlBuilder<EmptyConfig> money(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.MONEY, title);
    }

    /**
     * 日期事件控件
     *
     * @param title the title
     * @return the tmp control builder
     * @see DateValue
     */
    public static TmpControlBuilder<DateConfig> date(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.DATE, title);
    }

    /**
     * 单选、多选控件
     *
     * @param title the title
     * @return the tmp control builder
     * @see SelectorValue
     */
    public static TmpControlBuilder<SelectorConfig> selector(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.SELECTOR, title);
    }

    /**
     * 成员、部门控件
     *
     * @param title the title
     * @return the tmp control builder
     * @see ContactValue
     */
    public static TmpControlBuilder<ContactConfig> contact(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.CONTACT, title);
    }

    /**
     * Tips控件
     *
     * @param title the title
     * @return the tmp control builder
     */
    public static TmpControlBuilder<TipsConfig> tips(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.TIPS, title);
    }

    /**
     * 文件控件
     *
     * @param title the title
     * @return the tmp control builder
     * @see FileValue
     */
    public static TmpControlBuilder<FileConfig> file(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.FILE, title);
    }

    /**
     * 明细控件
     *
     * @param title the title
     * @return the tmp control builder
     * @see TableValue
     */
    public static TmpControlBuilder<TableConfig> table(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.TABLE, title);
    }

    /**
     * 假勤控件
     *
     * @param title the title
     * @return the tmp control builder
     * @see AttendanceValue
     */
    public static TmpControlBuilder<AttendanceConfig> attendance(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.ATTENDANCE, title);
    }

    /**
     * 请假控件
     *
     * @param title the title
     * @return the tmp control builder
     * @see VacationValue
     */
    public static TmpControlBuilder<VacationConfig> vacation(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.VACATION, title);
    }

    /**
     * 位置控件
     *
     * @param title the title
     * @return the tmp control builder
     * @see LocationValue
     */
    public static TmpControlBuilder<LocationConfig> location(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.LOCATION, title);
    }

    /**
     * 关联审批单控件
     *
     * @param title the title
     * @return the tmp control builder
     * @see RelatedApprovalValue
     */
    public static TmpControlBuilder<RelatedApprovalConfig> relatedApproval(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.RELATED_APPROVAL, title);
    }

    /**
     * 公式控件
     *
     * @param title the title
     * @return the tmp control builder
     * @see FormulaValue
     */
    public static TmpControlBuilder<FormulaConfig> formula(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.FORMULA, title);
    }

    /**
     * 手机号控件
     *
     * @param title the title
     * @return tmp control builder
     */
    public static TmpControlBuilder<EmptyConfig> phoneNumber(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.PHONE_NUMBER, title);
    }

    /**
     * 时长控件
     *
     * @param title the title
     * @return the tmp control builder
     * @see DateRangeValue
     */
    public static TmpControlBuilder<DateRangeConfig> dateRange(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.DATE_RANGE, title);
    }

    /**
     * 银行账户控件
     *
     * @param title the title
     * @return tmp control builder
     * @since 1.2.6
     */
    public static TmpControlBuilder<EmptyConfig> bankAccount(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.BANK_ACCOUNT, title);
    }

    /**
     * 构建审批表单组件
     *
     * @param config the config
     * @return the tmp control
     */
    public TmpControl<C> build(C config) {
        String id = control.getType()
                .concat("-")
                .concat(String.valueOf(RANDOM.nextInt(999999999)));
        CtrlProperty property = new CtrlProperty(this.control, id, this.title);
        property.setPlaceholder(this.placeholder);
        property.setRequire(this.require);
        property.setUnPrint(this.unPrint);
        return new TmpControl<>(property, config);
    }
}
