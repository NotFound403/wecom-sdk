package cn.felord.domain.approval;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * 关联控件
 *
 * @author dax
 * @since 2023 /10/12
 */
@ToString
@Getter
public class OpRelation {
    /**
     * 选项的控件ID
     */
    private final String key;
    /**
     * 关联的控件列表
     */
    private final List<Relation> relationList;

    /**
     * Instantiates a new Op relation.
     *
     * @param key          the key
     * @param relationList the relation list
     */
    @JsonCreator
    public OpRelation(@JsonProperty("key") String key,
                      @JsonProperty("relation_list") List<Relation> relationList) {
        this.key = key;
        this.relationList = relationList;
    }
}
