package cn.felord.domain.callcenter;

import cn.felord.WeComException;
import lombok.Getter;

import java.util.regex.Pattern;

/**
 * The type Kf account link request.
 *
 * @author dax
 * @since 2023 /5/24 15:25
 */
@Getter
public class KfAccountLinkRequest {
    private static final Pattern SCENE_REG = Pattern.compile("^[0-9a-zA-Z_-]$");
    private final String openKfid;
    private final String scene;

    /**
     * Instantiates a new Kf account link request.
     *
     * @param openKfid the open kfid
     */
    public KfAccountLinkRequest(String openKfid) {
        this(openKfid, null);
    }

    /**
     * Instantiates a new Kf account link request.
     *
     * @param openKfid the open kfid
     * @param scene    the scene
     */
    public KfAccountLinkRequest(String openKfid, String scene) {
        this.openKfid = openKfid;
        if (scene != null && !SCENE_REG.matcher(scene).matches()) {
            throw new WeComException("scene must be matched with ^[0-9a-zA-Z_-]$ ");
        }
        this.scene = scene;
    }
}
