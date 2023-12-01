package cn.felord.domain.msgaudit;

import lombok.Data;

import java.util.List;

/**
 * The type AgreeInfoRequest
 *
 * @author dax
 * @since 2023 /12/1
 */
@Data
public class AgreeInfoRequest {
    private final List<TwoSides> info;
}