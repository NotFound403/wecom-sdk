package cn.felord.domain.externalcontact;

import lombok.Data;

import java.time.Instant;

/**
 * @author dax
 * @since 2021/7/8 15:57
 */
@Data
public class ContactListRequest {
   private Instant startTime;
   private Instant endTime;
   private String cursor;
   private Integer limit;
}
