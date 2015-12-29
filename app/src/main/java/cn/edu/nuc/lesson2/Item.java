package cn.edu.nuc.lesson2;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Flming2015 on 2015/12/29.
 */
public class Item {
    private String userIcon;
    private String userName;
    private String content;
    private String image;
    private long userId;

    public Item(JSONObject object) throws JSONException {
        if (!object.isNull("user")) {
            userIcon = object.getJSONObject("user").getString("icon");
            userName = object.getJSONObject("user").getString("login");
            userId = object.getJSONObject("user").getLong("id");
        }
            content = object.getString("content");
            if (!object.isNull("image")) {
                image = object.getString("image");
            }
        }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public String getUserName() {
        return userName;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }
}
