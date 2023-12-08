package org.rsreu.library.logic;

public class LoginLogic {
    private final static String ADMIN_LOGIN = "admin";
    private final static String ADMIN_PASS = "123";
    private final static String LIBRARIAN_LOGIN = "librarian";
    private final static String LIBRARIAN_PASS = "123";
    // Add user type constants and passwords for users
    private final static String USER_LOGIN = "user";
    private final static String USER_PASS = "123";
    public enum UserType {
        ADMIN,
        LIBRARIAN,
        USER
        // Add more user types if needed
    }

    public static UserType checkLogin(String enterLogin, String enterPass) {
        if (ADMIN_LOGIN.equals(enterLogin) && ADMIN_PASS.equals(enterPass)) {
            return UserType.ADMIN;
        } else if (LIBRARIAN_LOGIN.equals(enterLogin) && LIBRARIAN_PASS.equals(enterPass)) {
            return UserType.LIBRARIAN;
        } else if (USER_LOGIN.equals(enterLogin) && USER_PASS.equals(enterPass)) {
            return UserType.USER;
        } else {
            // Handle user type for unrecognized credentials here
            return null;
        }
    }
}
