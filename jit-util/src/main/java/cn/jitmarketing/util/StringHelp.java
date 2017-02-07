package cn.jitmarketing.util;

/**
 * Created by Administrator on 2017/2/6/006.
 */
public class StringHelp {
    public static String noNull(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return (String) obj;
        }

    }
}
