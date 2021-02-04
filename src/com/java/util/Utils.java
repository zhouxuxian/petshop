package com.java.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日,hh时mm分ss秒");

    /**
     * 日期转换字符串
     * @param time
     * @return
     */
    public static  String format(LocalDateTime time){
        return formatter.format(time);
    }

    /**
     * 打印异常
     */
    public static void printException(Exception e){
        System.out.println("-------------------------------");
        //异常信息
        System.out.println("出现异常: " + e.getMessage());
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement:stackTrace){
            System.out.println("File="+stackTraceElement.getFileName());
            System.out.println("Line="+stackTraceElement.getLineNumber());
            System.out.println("Method="+stackTraceElement.getMethodName());
            System.out.println("at: "+stackTraceElement);
        }
        System.out.println("-------------------------------");
    }
    /**
     * 打印信息
     */
    public static void printInfo(Object obj,Double money){
        System.out.println("在"+format(LocalDateTime.now())+"出售了"+obj+"盈利"+money+"元");
    }

}
