package cn.felord.retrofit;

/**
 * @author dax
 * @since 2023/9/8
 */
public class VoidResponse {
    private final boolean successful;

    public VoidResponse() {
        this.successful = true;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
