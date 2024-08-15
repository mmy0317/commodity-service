package com.mayang.util;

public class StringUtil {

    /**
     * 将指定字符串str, 按照sourceArrays中的字符按顺序替换成targetArrays中的字符
     * 如果sourceArrays中出现相同的字符, 只会替换第一个
     * 示例:
     * str = "太阳当空照, 花儿对我笑, 小鸟说早早早";
     * sourceArrays = ["太阳","早","早","小鸟"]
     * targetArrays = ["sun","morning","111","bird"]
     * 转换后的str = "sun当空照, 花儿对我笑, bird说morning111早";
     * @param str
     * @param sourceArrays
     * @param targetArrays
     * @return
     */
    public static String replaceByArrays(String str, String[] sourceArrays, String[] targetArrays){
        String result = str;
        if (sourceArrays.length != targetArrays.length){
            throw new RuntimeException("sourceArrays length is not equals targetArrays length");
        }
        for (int i = 0; i < sourceArrays.length; i++){
            result = result.replaceFirst(sourceArrays[i],targetArrays[i]);
        }
        return result;
    }

    public static String replaceByArrays(String str, String source, Object... targetArrays){
        String result = str;
        for (int i = 0; i < targetArrays.length; i++){
            String target = targetArrays[i].toString();
            result = result.replaceFirst(source,target);
        }
        return result;
    }

}
