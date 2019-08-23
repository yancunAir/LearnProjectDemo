package yc.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常输出工具类
 */
public class ExceptionUtil {


    /**
     *  将异常以字符串的形式输出
     * @param e 异常
     * @return 字符串
     */

    public static String getStackTrace(Throwable e){
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        try{
            sw.close();
            pw.close();
        }catch(IOException exce){
            exce.printStackTrace();
        }
        return sw.toString();
    }


}
