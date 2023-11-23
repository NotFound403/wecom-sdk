package cn.felord.domain.living;

import lombok.Data;

import java.util.List;

/**
 * @author dax
 * @since 2023/5/24 11:36
 */
@Data
public class ActivityDetail {
    /**
     * 活动直播特定参数，活动直播简介
     */
    private String description;
    /**
     * 活动直播特定参数，活动直播附图的mediaId列表，最多支持传5张，超过五张取前五张
     */
    private List<String> imageList;
}