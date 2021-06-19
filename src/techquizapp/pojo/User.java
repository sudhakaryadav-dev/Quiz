/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

/**
 *
 * @author hp
 */
public class User {

    private String userId;

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public User(String userId, String password, String userType) {
        this.userId = userId;
        this.password = password;
        this.userType = userType;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    

    public String getUserType() {
        return userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    private String password;
    private String userType;
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
