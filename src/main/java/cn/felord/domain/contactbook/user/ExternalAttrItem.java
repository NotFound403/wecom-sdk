package cn.felord.domain.contactbook.user;

import lombok.Data;
/**
 * @author n1
 */
@Data
public class ExternalAttrItem{
	private String name;
	private Integer type;
	private Miniprogram miniprogram;
	private Web web;
	private Text text;
}