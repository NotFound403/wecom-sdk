package cn.felord.mp.domain.card;

import cn.felord.mp.enumeration.MemberCardFieldType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 自定义会员信息类目
 *
 * @author felord.cn
 * @since 1.0.0.RELEASE
 */
@Data
public class CustomField {
    /**
     * 会员信息类目半自定义名称，
     * 当开发者变更这类类目信息的value值时 可以选择触发系统模板消息通知用户
     */
    private final MemberCardFieldType nameType;
    /**
     * 会员信息类目自定义名称，
     * 当开发者变更这类类目信息的value值时 不会触发系统模板消息通知用户
     */
    private final String name;
    /**
     * 点击类目跳转外链url
     */
    private final String url;


    /**
     * Instantiates a new Custom field.
     *
     * @param nameType the name type
     */
    public CustomField(MemberCardFieldType nameType) {
        this(nameType, null);

    }

    /**
     * Instantiates a new Custom field.
     *
     * @param nameType the name type
     * @param name     the name
     */
    public CustomField(MemberCardFieldType nameType, String name) {
        this(nameType, name, null);
    }

    /**
     * Instantiates a new Custom field.
     *
     * @param nameType the name type
     * @param name     the name
     * @param url      the url
     */
    @JsonCreator
    public CustomField(@JsonProperty("name_type") MemberCardFieldType nameType,
                       @JsonProperty("name") String name,
                       @JsonProperty("url") String url) {
        this.nameType = nameType;
        this.name = name;
        this.url = url;
    }
}