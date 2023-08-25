package cn.felord.payment.wechat.v3.domain;

import lombok.Data;

/**
 * @author dax
 * @since 2023/8/25
 */
@Data
public class GenericData<T> {
    private T data;
}
