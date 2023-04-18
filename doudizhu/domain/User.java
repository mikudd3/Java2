package itheima.java2.doudizhu.domain;

import java.util.Objects;

public class User {
    private String username;
    private String password;


    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * ��ȡ
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * ����
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * ��ȡ
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * ����
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    public String toString() {
        return "User{username = " + username + ", password = " + password + "}";
    }
}
