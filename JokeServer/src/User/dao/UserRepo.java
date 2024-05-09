package User.dao;

import User.Model.User;

public interface UserRepo {
    static void createUser(String username, String password) {

    }
    boolean createMember(String username);
    boolean createAdmin(String username);
    static void userLogin(String username, String password) {

    }
    void memberLogin(String username, String password);
    void adminLogin(String username, String password);
    void updateUser(String username, String password, String newPassword);
    void deleteUser(String username);
}
