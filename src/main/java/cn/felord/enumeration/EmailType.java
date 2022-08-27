package cn.felord.enumeration;

/**
 * @author dax
 * @since 1.0.14.RELEASE
 */
public enum EmailType {

    CORP(1,"企业邮箱（默认）"),
    PERSONAL(1,"企业邮箱（默认）");


    private final Integer type;
    private final String description;

    EmailType(Integer type,String description) {
        this.type = type;
        this.description = description;
    }

    public Integer type(){
        return this.type;
    }

    public String description(){
        return this.description;
    }
}
