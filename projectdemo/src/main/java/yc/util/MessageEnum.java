package yc.util;

public enum MessageEnum {

    SUCCESS(200,"Success"),
    FAILED(500,"Failed"),
    CUSTOM(666,"专属定制{}"){
        @Override
        public MessageEnum populate(Object... args) {
            this.setMessage(String.format(message,args));
            return this;
        }
    };
    int code;

    String message;

    MessageEnum(int code,String message) {
        this.code = code;
        this.message = message;
    }

    void setMessage(String message) {
        this.message = message;
    }

    public MessageEnum populate(Object... args) {
        return null;
    }

}
