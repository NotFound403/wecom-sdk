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
public class ImageWorkbenchTemplate extends WorkbenchTemplate {
    private final Image image;

    /**
     * Instantiates a new Image workbench template.
     *
     * @param agentid the agentid
     * @param image   the image
     */
    public ImageWorkbenchTemplate(String agentid, Image image) {
        this(agentid, false, image);
    }

    /**
     * Instantiates a new Image workbench template.
     *
     * @param agentid         the agentid
     * @param replaceUserData the replace user data
     * @param image           the image
     */
    @JsonCreator
    public ImageWorkbenchTemplate(@JsonProperty("agentid") String agentid,
                                  @JsonProperty("replace_user_data") boolean replaceUserData,
                                  @JsonProperty("image") Image image) {
        super(agentid, replaceUserData, WorkbenchType.IMAGE);
        this.image = image;
    }
}
