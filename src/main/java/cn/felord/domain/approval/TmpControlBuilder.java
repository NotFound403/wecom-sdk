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
 * @since 2023 /5/25 16:00
 */
public final class TmpControlBuilder<C> {
    private static final Random RANDOM = new SecureRandom();
    private final ApprovalCtrlType control;
    private final String id;
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
        this.id = control.getType().concat("-").concat(String.valueOf(RANDOM.nextInt(999999999)));
        this.title = Collections.singletonList(ApprovalTitle.createzhCN(title));
    }

    /**
     * Placeholder tmp control builder.
     *
     * @param placeholder the placeholder
     * @return the tmp control builder
     */
    public TmpControlBuilder<C> placeholder(String placeholder) {
        this.placeholder = Collections.singletonList(ApprovalTitle.createzhCN(placeholder));
        return this;
    }

    /**
     * Require tmp control builder.
     *
     * @param require the require
     * @return the tmp control builder
     */
    public TmpControlBuilder<C> require(BoolEnum require) {
        this.require = require;
        return this;
    }

    /**
     * Un print tmp control builder.
     *
     * @param unPrint the un print
     * @return the tmp control builder
     */
    public TmpControlBuilder<C> unPrint(BoolEnum unPrint) {
        this.unPrint = unPrint;
        return this;
    }

    /**
     * Text tmp control builder.
     *
     * @param title the title
     * @return the tmp control builder
     */
    public static TmpControlBuilder<EmptyConfig> text(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.TEXT, title);
    }

    /**
     * Textarea tmp control builder.
     *
     * @param title the title
     * @return the tmp control builder
     */
    public static TmpControlBuilder<EmptyConfig> textarea(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.TEXTAREA, title);
    }

    /**
     * Number tmp control builder.
     *
     * @param title the title
     * @return the tmp control builder
     */
    public static TmpControlBuilder<EmptyConfig> number(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.NUMBER, title);
    }

    /**
     * Money tmp control builder.
     *
     * @param title the title
     * @return the tmp control builder
     */
    public static TmpControlBuilder<EmptyConfig> money(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.MONEY, title);
    }

    /**
     * Date tmp control builder.
     *
     * @param title the title
     * @return the tmp control builder
     */
    public static TmpControlBuilder<DateConfig> date(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.DATE, title);
    }

    /**
     * Selector tmp control builder.
     *
     * @param title the title
     * @return the tmp control builder
     */
    public static TmpControlBuilder<SelectorConfig> selector(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.SELECTOR, title);
    }

    /**
     * Contact tmp control builder.
     *
     * @param title the title
     * @return the tmp control builder
     */
    public static TmpControlBuilder<ContactConfig> contact(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.CONTACT, title);
    }

    /**
     * Tips tmp control builder.
     *
     * @param title the title
     * @return the tmp control builder
     */
    public static TmpControlBuilder<EmptyConfig> tips(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.TIPS, title);
    }

    /**
     * File tmp control builder.
     *
     * @param title the title
     * @return the tmp control builder
     */
    public static TmpControlBuilder<FileConfig> file(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.FILE, title);
    }

    /**
     * Table tmp control builder.
     *
     * @param title the title
     * @return the tmp control builder
     */
    public static TmpControlBuilder<TableConfig> table(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.TABLE, title);
    }

    /**
     * Attendance tmp control builder.
     *
     * @param title the title
     * @return the tmp control builder
     */
    public static TmpControlBuilder<AttendanceConfig> attendance(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.ATTENDANCE, title);
    }

    /**
     * Vacation tmp control builder.
     *
     * @param title the title
     * @return the tmp control builder
     */
    public static TmpControlBuilder<VacationConfig> vacation(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.VACATION, title);
    }

    /**
     * Location tmp control builder.
     *
     * @param title the title
     * @return the tmp control builder
     */
    public static TmpControlBuilder<LocationConfig> location(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.LOCATION, title);
    }

    /**
     * Related approval tmp control builder.
     *
     * @param title the title
     * @return the tmp control builder
     */
    public static TmpControlBuilder<RelatedApprovalConfig> relatedApproval(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.RELATED_APPROVAL, title);
    }

    /**
     * Formula tmp control builder.
     *
     * @param title the title
     * @return the tmp control builder
     */
    public static TmpControlBuilder<FormulaConfig> formula(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.FORMULA, title);
    }

    /**
     * Date range tmp control builder.
     *
     * @param title the title
     * @return the tmp control builder
     */
    public static TmpControlBuilder<DateRangeConfig> dateRange(String title) {
        return new TmpControlBuilder<>(ApprovalCtrlType.DATE_RANGE, title);
    }

    /**
     * Init empty config ctrl tmp control.
     *
     * @param config the config
     * @return the tmp control
     */
    public TmpControl<C> build(C config) {
        CtrlProperty property = new CtrlProperty(this.control, this.id, this.title);
        property.setPlaceholder(this.placeholder);
        property.setRequire(this.require);
        property.setUnPrint(this.unPrint);
        return new TmpControl<>(property, config);
    }
}
