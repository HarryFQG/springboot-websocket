package pojo.message;

/**
 * 接受的人po
 */
public class ToServerMessageTo {

    /**
     * 群组ID或者用户的ID
     */
    private int id;

    /**
     * 用户的图像
     */
    private String avatar;

    /**
     * 签名
     */
    private String sign;

    /**
     * 消息类型(group/friend)
     */
    private String type;
    /**
     * 用户的名字
     */
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }


}
