package io.openvidu.mvc.java;


public class ModelDAO {

    private String sessionName;
    private String token;
    private String nickName;
    private String userName;
    private String activeAt;
    private String adaptativeBitrate;
    private String clientData;
    private String connectionId;
    private String createdAt;
    private String id;
    private String kurentoOptions;
    private String location;
    private String networkCache;
    private String object;
    private String onlyPlayWithSubscribers;
    private String platform;
    private String publishers;
    private boolean record;
    private String role;
    private String rtspUri;
    private String serverData;
    private String sessionId;
    private String status;
    private String subscribers;
    private String type;


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

//    public ModelDAO(String sessionName, String token, String nickName, String userName) {
//        this.sessionName = sessionName;
//        this.token = token;
//        this.nickName = nickName;
//        this.userName = userName;
//    }


//    public ModelDAO(String sessionName, String token, String nickName, String userName) {
//        this.sessionName = sessionName;
//        this.token = token;
//        this.nickName = nickName;
//        this.userName = userName;
//        this.activeAt = null;
//        this.adaptativeBitrate = null;
//        this.clientData = null;
//        this.connectionId = "con_LCqpy3ZypO";
//        this.createdAt = "1626534264126";
//        this.id = "con_LCqpy3ZypO";
//        this.kurentoOptions = null;
//        this.location = null;
//        this.networkCache = null;
//        this.object = "connection";
//        this.onlyPlayWithSubscribers = null;
//        this.platform = null;
//        this.publishers = null;
//        this.record = true;
//        this.role = "PUBLISHER";
//        this.rtspUri = null;
//        this.serverData = "";
//        this.sessionId = "SessionA";
//        this.status = "pending";
//        this.subscribers = null;
//        this.type = "WEBRTC";
//    }


    public ModelDAO(String sessionName, String token, String nickName, String userName, String activeAt, String adaptativeBitrate, String clientData, String connectionId, String createdAt, String id, String kurentoOptions, String location, String networkCache, String object, String onlyPlayWithSubscribers, String platform, String publishers, boolean record, String role, String rtspUri, String serverData, String sessionId, String status, String subscribers, String type) {
        this.sessionName = sessionName;
        this.token = token;
        this.nickName = nickName;
        this.userName = userName;
        this.activeAt = activeAt;
        this.adaptativeBitrate = adaptativeBitrate;
        this.clientData = clientData;
        this.connectionId = connectionId;
        this.createdAt = createdAt;
        this.id = id;
        this.kurentoOptions = kurentoOptions;
        this.location = location;
        this.networkCache = networkCache;
        this.object = object;
        this.onlyPlayWithSubscribers = onlyPlayWithSubscribers;
        this.platform = platform;
        this.publishers = publishers;
        this.record = record;
        this.role = role;
        this.rtspUri = rtspUri;
        this.serverData = serverData;
        this.sessionId = sessionId;
        this.status = status;
        this.subscribers = subscribers;
        this.type = type;
    }

    public String getActiveAt() {
        return activeAt;
    }

    public void setActiveAt(String activeAt) {
        this.activeAt = activeAt;
    }

    public String getAdaptativeBitrate() {
        return adaptativeBitrate;
    }

    public void setAdaptativeBitrate(String adaptativeBitrate) {
        this.adaptativeBitrate = adaptativeBitrate;
    }

    public String getClientData() {
        return clientData;
    }

    public void setClientData(String clientData) {
        this.clientData = clientData;
    }

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKurentoOptions() {
        return kurentoOptions;
    }

    public void setKurentoOptions(String kurentoOptions) {
        this.kurentoOptions = kurentoOptions;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNetworkCache() {
        return networkCache;
    }

    public void setNetworkCache(String networkCache) {
        this.networkCache = networkCache;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getOnlyPlayWithSubscribers() {
        return onlyPlayWithSubscribers;
    }

    public void setOnlyPlayWithSubscribers(String onlyPlayWithSubscribers) {
        this.onlyPlayWithSubscribers = onlyPlayWithSubscribers;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public boolean isRecord() {
        return record;
    }

    public void setRecord(boolean record) {
        this.record = record;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRtspUri() {
        return rtspUri;
    }

    public void setRtspUri(String rtspUri) {
        this.rtspUri = rtspUri;
    }

    public String getServerData() {
        return serverData;
    }

    public void setServerData(String serverData) {
        this.serverData = serverData;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(String subscribers) {
        this.subscribers = subscribers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
