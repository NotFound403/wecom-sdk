package cn.felord.domain.agent;

import cn.felord.enumeration.WorkbenchType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The type Image workbench template.
 *
 * @author dax
 * @since 2023 /10/25
 */
@ToString
@Getter
public class UserImageWorkbenchTemplate extends UserWorkbenchTemplate {
    private final Image image;

    /**
     * Instantiates a new User image workbench template.
     *
     * @param agentid the agentid
     * @param userid  the userid
     * @param image   the image
     */
    @JsonCreator
    public UserImageWorkbenchTemplate(@JsonProperty("agentid") String agentid,
                                      @JsonProperty("userid") String userid,
                                      @JsonProperty("image") Image image) {
        super(agentid, userid, WorkbenchType.IMAGE);
        this.image = image;
    }
}
