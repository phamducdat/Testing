package io.openvidu.mvc.java;



public class ModelDAO {

    private String sessionName;
    private String token;
    private String nickName;
    private String userName;

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ModelDAO(String sessionName, String token, String nickName, String userName) {
        this.sessionName = sessionName;
        this.token = token;
        this.nickName = nickName;
        this.userName = userName;
    }
}
