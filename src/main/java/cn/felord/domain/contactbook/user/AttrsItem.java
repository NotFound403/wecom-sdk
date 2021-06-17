package cn.felord.domain.contactbook.user;

import lombok.Data;

/**
 * @author n1
 */
@Data
public class AttrsItem {
    private Web web;
    private String name;
    private Integer type;
    private Text text;
}