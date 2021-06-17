package cn.felord.api.contactbook;

import cn.felord.Agent;

/**
 * 通讯录Agent,参见文档中关于通讯录管理的<a target= "_blank" href= "https://work.weixin.qq.com/api/doc/90000/90135/90193">概述</a>
 * <p>
 * 管理工具-通讯录同步
 *
 * @author n1
 * @since 2021 /6/17 14:30
 */
public class ContactBookAgent extends Agent {

    /**
     * Instantiates a new Contact book agent.
     *
     * @param corpId   the corp id
     * @param secret   the secret
     * @param corpName the corp name
     */
    public ContactBookAgent(String corpId, String secret, String corpName) {
        super(corpId, secret, corpName, "", "contact book agent");
    }
}
