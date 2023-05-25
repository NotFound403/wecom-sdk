package cn.felord.domain.approval;

import lombok.Getter;

/**
 * The type Approval title.
 *
 * @author xiafang
 * @since 2023 /5/25 14:25
 */
@Getter
public class ApprovalTitle {
    private final String text;
    private final String lang;

    /**
     * Instantiates a new Approval title.
     *
     * @param text the text
     * @param lang the lang
     */
    public ApprovalTitle(String text, String lang) {
        this.text = text;
        this.lang = lang;
    }

    /**
     * Createzh cn approval title.
     *
     * @param text the text
     * @return the approval title
     */
    public static ApprovalTitle createzhCN(String text) {
        return new ApprovalTitle(text, "zh_CN");
    }

}
