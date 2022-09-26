package cn.felord.domain.externalcontact;

import cn.felord.enumeration.CreateType;
import cn.felord.enumeration.MomentVisibleType;
import lombok.Data;

import java.time.Instant;
import java.util.Set;

/**
 * @author dax
 * @since 2021/8/21 17:14
 */
@Data
public class MomentDetail {
     private String momentId;
     private String creator;
     private Instant createTime;
     private MomentVisibleType visibleType;
     private CreateType createType;
     private Text text;
     private Set<MediaId> image;
     private MomentDetailVideo video;
     private MomentLink link;
     private MomentLocation location;

     @Data
     public static class MomentDetailVideo {
          private String mediaId;
          private String thumbMediaId;
     }
}
