package yc.designpattern.strategy;

public enum MessageType {

    TEXT(1,"文本"),
    IMAGE(2,"图片");

    public final int code;

    public final String message;

    MessageType(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
