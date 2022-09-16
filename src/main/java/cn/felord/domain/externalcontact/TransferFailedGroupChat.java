package cn.felord.domain.externalcontact;

import lombok.Data;

/**
 * @author dax
 * @since 2021/7/14 15:30
 */
@Data
public class TransferFailedGroupChat {
  private String chatId;
  private Integer errcode;
  private String errmsg;
}
