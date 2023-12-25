package org.rsreu.library.databaseutil.entity;

/**
 * The User class represents user data in the system.
 */
public class User {

    private Long id; // Unique identifier for the user
    private String type; // Type of user (e.g., admin, regular)
    private String login; // User's login ID
    private String password; // User's password
    private String status; // Status of the user account (e.g., active, inactive)
    private String name; // User's name

    /**
     * Retrieves the unique identifier of the user.
     *
     * @return The user's ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the user.
     *
     * @param id The user's ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the type of user.
     *
     * @return The type of user
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of user.
     *
     * @param type The type of user to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Retrieves the user's login ID.
     *
     * @return The user's login ID
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the user's login ID.
     *
     * @param login The user's login ID to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Retrieves the user's password.
     *
     * @return The user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     *
     * @param password The user's password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the status of the user account.
     *
     * @return The status of the user account
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the user account.
     *
     * @param status The status of the user account to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Retrieves the name of the user.
     *
     * @return The user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name The user's name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
