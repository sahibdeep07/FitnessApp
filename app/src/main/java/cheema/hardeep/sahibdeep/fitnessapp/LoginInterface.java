package cheema.hardeep.sahibdeep.fitnessapp;

import cheema.hardeep.sahibdeep.fitnessapp.model.UserResponse;

public interface LoginInterface {

    void onSuccess(UserResponse userResponse);

    void onFailure(Throwable error);
}
