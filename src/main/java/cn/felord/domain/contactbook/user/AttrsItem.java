package cn.felord.domain.contactbook.user;

import lombok.Data;

/**
 * @author n1
 */
@Data
public class AttrsItem {
    private Integer type;
    private String name;
    private Web web;
    private Text text;
}