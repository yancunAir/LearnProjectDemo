package yc.controller;



import java.io.Serializable;

public class ControllerResponse<T>  implements Serializable {


    private static final long serialVersionUID = 1L;

    private int status;

    private String statusText;

    private T data;

    ControllerResponse(){
        status = 0;
        statusText = "success";
    }

    public ControllerResponse(int status,String statusText,T data){
        this.status = status;
        this.statusText = statusText;
        this.data = data;
    }
    public int getStatus(){
        return this.status;
    }
    public void setStatus(int status){
        this.status = status;
    }
    public String getStatusText(){
        return this.statusText;
    }
    public void setStatusText(String statusText){
        this.statusText = statusText;
    }
    public T getData(){
        return data;
    }
    public void setData(T data){
        this.data = data;
    }


}
