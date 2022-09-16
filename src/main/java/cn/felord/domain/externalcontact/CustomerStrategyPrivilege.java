package cn.felord.domain.externalcontact;

import lombok.Data;

/**
 * @author dax
 * @since 2021/7/12 15:18
 */
@Data
public class CustomerStrategyPrivilege {
    private Boolean viewCustomerList;
    private Boolean viewCustomerData;
    private Boolean viewRoomList;
    private Boolean contactMe;
    private Boolean joinRoom;
    private Boolean shareCustomer;
    private Boolean operResignCustomer;
    private Boolean operResignGroup;
    private Boolean sendCustomerMsg;
    private Boolean editWelcomeMsg;
    private Boolean viewBehaviorData;
    private Boolean viewRoomData;
    private Boolean sendGroupMsg;
    private Boolean roomDeduplication;
    private Boolean rapidReply;
    private Boolean onjobCustomerTransfer;
    private Boolean editAntiSpamRule;
    private Boolean exportCustomerList;
    private Boolean exportCustomerData;
    private Boolean exportCustomerGroupList;
    private Boolean manageCustomerTag;
}
