
package cheema.hardeep.sahibdeep.fitnessapp.model;

import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class User {

    @Expose
    private String age;
    @Expose
    private String firstName;
    @Expose
    private String height;
    @Expose
    private String lastName;
    @Expose
    private String weight;
    @Expose
    private String username;
    @Expose
    private String password;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

}
