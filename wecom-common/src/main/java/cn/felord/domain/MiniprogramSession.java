package cn.felord.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * 企业小程序session
 *
 * @author dax
 * @since 2023 /10/12
 */
public class MiniprogramSession {
    private final String userid;
    private final String sessionKey;

    /**
     * Instantiates a new Miniprogram session.
     *
     * @param userid     the userid
     * @param sessionKey the session key
     */
    @JsonCreator
    public MiniprogramSession(@JsonProperty("userid") String userid,
                              @JsonProperty("session_key") String sessionKey) {
        this.userid = userid;
        this.sessionKey = sessionKey;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Gets session key.
     *
     * @return the session key
     */
    public String getSessionKey() {
        return sessionKey;
    }

    @Override
    public String toString() {
        return "MiniprogramSession{" +
                "userid='" + userid + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MiniprogramSession that = (MiniprogramSession) o;

        if (!Objects.equals(userid, that.userid)) return false;
        return Objects.equals(sessionKey, that.sessionKey);
    }

    @Override
    public int hashCode() {
        int result = userid != null ? userid.hashCode() : 0;
        result = 31 * result + (sessionKey != null ? sessionKey.hashCode() : 0);
        return result;
    }
}
