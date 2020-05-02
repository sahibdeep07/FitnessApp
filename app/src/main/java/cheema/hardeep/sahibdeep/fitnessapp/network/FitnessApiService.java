package cheema.hardeep.sahibdeep.fitnessapp.network;

import cheema.hardeep.sahibdeep.fitnessapp.model.User;
import io.reactivex.Observable;

public interface FitnessApiService {

    Observable<User> createUser(User user);

    Observable<User> login(User user);
}
