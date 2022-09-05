package cn.felord.enumeration;

/**
 * The enum Email type.
 *
 * @author felord.cn
 * @since 1.0.14.RELEASE
 */
public enum EmailType {

    /**
     * 企业邮箱.
     */
    CORP(1,"企业邮箱（默认）"),
    /**
     * 个人邮箱.
     */
    PERSONAL(2,"个人邮箱");


    private final Integer type;
    private final String description;

    EmailType(Integer type,String description) {
        this.type = type;
        this.description = description;
    }

    /**
     * Type integer.
     *
     * @return the integer
     */
    public Integer type(){
        return this.type;
    }

    /**
     * Description string.
     *
     * @return the string
     */
    public String description(){
        return this.description;
    }
}
