package cn.digitalScene.Utils;

import java.util.regex.Pattern;

/**
 * Created by 25065 on 2017/3/14.
 */
public class StringUtils {

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

//    public static void main(String[] args) {
//        if (isInteger("2,3")){
//            System.out.println("整型");
//        }else {
//            System.out.println("字符串");
//        }
//    }
}
