package cn.felord.domain.contactbook.user;

import lombok.Data;

import java.util.List;

/**
 * @author n1
 * @since 2021/6/17 19:38
 */
@Data
public class BatchInviteRequest {
  private List<String> user;
  private List<String> party;
  private List<String> tag;
}
