package cn.felord.mp.domain.message;

import lombok.Data;

import java.util.Map;

@Data
public class MessageBody {
    private String touser;
    private String clientMsgId;
    private Map<String, TemplateValue> data;
    private String templateId;
    private Miniprogram miniprogram;
    private String url;
}