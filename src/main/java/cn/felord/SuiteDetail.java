package cn.felord;

import lombok.AllArgsConstructor;

/**
 * @author dax
 * @since 2021/12/8 10:08
 */
@AllArgsConstructor
public class SuiteDetail {
    private final String suiteId;
    private final String suiteSecret;
    private String suiteTicket;

    void setSuiteTicket(String suiteTicket) {
        this.suiteTicket = suiteTicket;
    }

    public String getSuiteId() {
        return suiteId;
    }

    public String getSuiteSecret() {
        return suiteSecret;
    }

    public String getSuiteTicket() {
        return suiteTicket;
    }
}
