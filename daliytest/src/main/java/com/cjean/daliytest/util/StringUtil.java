package com.cjean.daliytest.util;

/**
 * @Auther: liuzaihuan
 * @Date: 2019/3/29 16:31
 * @Description: 字符串工具类
 */
public class StringUtil {
    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return null == str || "".equals(String.valueOf(str));
    }
    
    /**
     * 判断字符串是否不为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !(isEmpty(str));
    }
 
 
    /**
     * 对象转字符串
     *
     * @param obj
     * @return
     */
    public static String getString(Object obj) {
        if (obj instanceof String)
            return (String) obj;
        return null == obj ? "" : String.valueOf(obj);
    }
 
    /**
     * 字符串截取
     *
     * @param str    被截取的字符串
     * @param len    截取长度
     * @param isHead 是否从头开始 ，false - 尾部开始
     * @return
     */
    public static String subString(String str, int len, boolean isHead) {
        if (len == 0) {
            return str;
        }
        if (isHead)
            return str.length() < len ? str : str.substring(0, len);
        return str.length() < len ? str : str.substring(len, str.length() - len);
    }
 
    /**
     * 字符串截取
     *
     * @param str   被截取的字符串
     * @param index 开始截取标志（第一次出现的位置）
     * @return
     */
    public static String subString(String str, String index) {
        int fromIndex = str.indexOf(index);
        if (fromIndex == -1)
            return str;
        return str.substring(0, fromIndex);
    }
 
    /**
     * 字符串倒序
     *
     * @param str
     *          需要倒序的字符串
     * @return
     */
    public static String reverse(String str) {
        return new StringBuffer(str).reverse().toString();
    }
 
    /**
     * 每隔 n 位添加一个 字符（symbol）
     * seq = true  123.456.78
     * seq = false 12.345.678
     * @param str
     *          原字符串
     * @param symbol
     *          需要添加的字符
     * @param n
     *          每隔几位添加字符
     * @param seq
     *          从头n位，还是从尾n位
     * @return
     */
    public static String addSymbol(String str, String symbol, int n, boolean seq) {
        if (n > str.length() || n < 1)
            return str;
        StringBuffer sb = new StringBuffer();
        int size = str.length() % n == 0 ? str.length() / n : str.length() / n + 1;
        if(!seq)
            str = reverse(str);
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                sb.append(str.substring(i * n, str.length()));
            }else {
                sb.append(str.substring(i * n, (i + 1) * n) + symbol);
            }
        }
        return sb.reverse().toString();
    }
 
}
