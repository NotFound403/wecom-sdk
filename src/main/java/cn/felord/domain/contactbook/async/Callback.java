package cn.felord.domain.contactbook.async;

import lombok.Data;

/**
 * @author n1
 * @since 2021/8/17 18:07
 */
@Data
public class Callback {
    private String url;
    private String token;
    private String encodingaeskey;
}
