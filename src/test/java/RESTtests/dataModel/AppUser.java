package RESTtests.dataModel;

/**
 * Created by User on 19/02/2017.
 */
public class AppUser {
    private String userName;
    private String userPassword;
    private String userToken;

    public AppUser(String userName, String userPassword, String userToken) {
        this.userName = userName ;
        this.userPassword = userPassword;
        this.userToken = userToken;
    }

    public String getUserName() {
        return userName;
    }

    public AppUser withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public AppUser withUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public String getUserToken() {
        return userToken;
    }

    public AppUser withUserToken(String userToken) {
        this.userToken = userToken;
        return this;
    }
}

