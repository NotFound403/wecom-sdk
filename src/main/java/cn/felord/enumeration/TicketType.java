package cn.felord.enumeration;

/**
 * @author dax
 */
public enum TicketType {
    AGENT_CONFIG("agent_config");

    private final String type;
    TicketType(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }
}
