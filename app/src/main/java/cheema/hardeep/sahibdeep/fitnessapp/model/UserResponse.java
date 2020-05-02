package cheema.hardeep.sahibdeep.fitnessapp.model;

import com.google.gson.annotations.Expose;

public class UserResponse {
    @Expose
    private int code;

    @Expose
    private String message;

    @Expose
    private User data;

    @Expose
    private String error;

    public int getCode() { return code; }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
