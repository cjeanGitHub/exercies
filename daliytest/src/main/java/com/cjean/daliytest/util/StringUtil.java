package com.cjean.daliytest.util;

/**
 * @Auther: liuzaihuan
 * @Date: 2019/3/29 16:31
 * @Description: �ַ���������
 */
public class StringUtil {
    /**
     * �ж��ַ����Ƿ�Ϊ��
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return null == str || "".equals(String.valueOf(str));
    }
    
    /**
     * �ж��ַ����Ƿ�Ϊ��
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !(isEmpty(str));
    }
 
 
    /**
     * ����ת�ַ���
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
     * �ַ�����ȡ
     *
     * @param str    ����ȡ���ַ���
     * @param len    ��ȡ����
     * @param isHead �Ƿ��ͷ��ʼ ��false - β����ʼ
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
     * �ַ�����ȡ
     *
     * @param str   ����ȡ���ַ���
     * @param index ��ʼ��ȡ��־����һ�γ��ֵ�λ�ã�
     * @return
     */
    public static String subString(String str, String index) {
        int fromIndex = str.indexOf(index);
        if (fromIndex == -1)
            return str;
        return str.substring(0, fromIndex);
    }
 
    /**
     * �ַ�������
     *
     * @param str
     *          ��Ҫ������ַ���
     * @return
     */
    public static String reverse(String str) {
        return new StringBuffer(str).reverse().toString();
    }
 
    /**
     * ÿ�� n λ���һ�� �ַ���symbol��
     * seq = true  123.456.78
     * seq = false 12.345.678
     * @param str
     *          ԭ�ַ���
     * @param symbol
     *          ��Ҫ��ӵ��ַ�
     * @param n
     *          ÿ����λ����ַ�
     * @param seq
     *          ��ͷnλ�����Ǵ�βnλ
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
