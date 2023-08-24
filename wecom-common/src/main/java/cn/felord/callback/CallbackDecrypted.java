package cn.felord.callback;

/**
 * @author dax
 * @since 2023/8/24
 */

public class CallbackDecrypted {
    private final String receiveid;
    private final String content;

    CallbackDecrypted(String content, String receiveid) {
        this.content = content;
        this.receiveid = receiveid;
    }

    public String getReceiveid() {
        return receiveid;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "CallbackDecrypted{" +
                "receiveid='" + receiveid + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
