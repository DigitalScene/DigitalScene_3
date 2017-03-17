package cn.digitalScene.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 25065 on 2017/3/14.
 */
public class TimeStringUtils {

    private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String timeToString(Date date){
        return format.format(date);
    }

    public static Date stringToTime(String date){
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
