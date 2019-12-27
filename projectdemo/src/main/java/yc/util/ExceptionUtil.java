package yc.util;

import org.apache.commons.lang3.time.StopWatch;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * 异常输出工具类
 */
public class ExceptionUtil {


    public static void main(String[] args) {
        System.out.println(demo ());
    }

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


    public static String demo () {
        StopWatch watch = new StopWatch();
        try {
            watch.start();

           Thread.sleep(2000);



            throw new Exception("1");
        }
        catch (Exception ex)  {
            System.out.println("catch");
            return "Success";
        }
        finally {
            watch.stop();
            System.out.println("finally");
            System.out.println("花费时间：" +watch.getTime(TimeUnit.SECONDS));
            return "finallytwo";
        }



    }

}
