package yc.util;


/**
 * 性别枚举类
 * 1.男 2.女 3.未知
 */
public enum GenderEnum {


    MAN(1,"男生"),WOMEN(2,"女生"),UNKNOW(3,"未知");

    private int code;
    private String text;


    GenderEnum(int code ,String text){
        this.code = code ;
        this.text = text;
    }

    public void setCode(int code){
        this.code = code;
    }

    public int getCode(){
       return this.code;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }

    public String getText(int code){
        for(GenderEnum genderEnum :GenderEnum.values()){
            if(genderEnum.getCode() == code){
                return genderEnum.getText();
            }
        }
        return null;
    }
}
