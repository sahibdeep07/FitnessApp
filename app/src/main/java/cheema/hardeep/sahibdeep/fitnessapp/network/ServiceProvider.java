package cheema.hardeep.sahibdeep.fitnessapp.network;

public class ServiceProvider {

    public static FitnessApiService provideFitnessApiService() {
        FitnessApiServiceProvider fitnessApiServiceProvider = new FitnessApiServiceProvider();
        return fitnessApiServiceProvider;
    }
}
