package cn.digitalScene.Utils;

/**
 * Created by 25065 on 2017/3/12.
 */
public class PageUtils {

    //返回当前的页码
    public static Integer returnPageCurrent(Integer pageCurrent,Integer parameterCountNow,Integer parameterCountBefore,Integer pageNumbers){
        if (pageCurrent==null||pageCurrent.equals("")){
            pageCurrent=0;
        }else if(parameterCountNow!=parameterCountBefore){
            pageCurrent=0;
//            parameterCountBefore=parameterCountNow;
        }else if (pageCurrent>pageNumbers){
            pageCurrent=0;
        }else {
            pageCurrent=pageCurrent-1;
        }
        return pageCurrent;
    }
}
