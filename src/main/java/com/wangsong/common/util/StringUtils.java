package com.wangsong.common.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static String lowerFirst(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        } else {
            return str.substring(0, 1).toLowerCase() + str.substring(1);
        }
    }

    public static String upperFirst(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        } else {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }

    /**
     * 替换掉HTML标签方法
     */
    public static String replaceHtml(String html) {
        if (isBlank(html)) {
            return "";
        }
        String regEx = "<.+?>";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(html);
        String s = m.replaceAll("");
        return s;
    }

    /**
     * 缩略字符串（不区分中英文字符）
     *
     * @param str    目标字符串
     * @param length 截取长度
     * @return
     */
    public static String abbr(String str, int length) {
        if (str == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int currentLength = 0;
            for (char c : replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
                currentLength += String.valueOf(c).getBytes("GBK").length;
                if (currentLength <= length - 3) {
                    sb.append(c);
                } else {
                    sb.append("...");
                    break;
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 缩略字符串（替换html）
     *
     * @param str    目标字符串
     * @param length 截取长度
     * @return
     */
    public static String rabbr(String str, int length) {
        return abbr(replaceHtml(str), length);
    }


    /**
     * 转换为Double类型
     */
    public static Double toDouble(Object val) {
        if (val == null) {
            return 0D;
        }
        try {
            return Double.valueOf(trim(val.toString()));
        } catch (Exception e) {
            return 0D;
        }
    }

    /**
     * 转换为Float类型
     */
    public static Float toFloat(Object val) {
        return toDouble(val).floatValue();
    }

    /**
     * 转换为Long类型
     */
    public static Long toLong(Object val) {
        return toDouble(val).longValue();
    }

    /**
     * 转换为Integer类型
     */
    public static Integer toInteger(Object val) {
        return toLong(val).intValue();
    }


    public static String bigDecimalAdd(String val, String val2) {
        return new BigDecimal(val).add(new BigDecimal(val2)).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString();
    }

    public static String bigDecimalSubtract(String val, String val2) {
        return new BigDecimal(val).subtract(new BigDecimal(val2)).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString();
    }

    public static String bigDecimalMultiply(String val, String val2) {
        return new BigDecimal(val).multiply(new BigDecimal(val2)).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString();
    }

    public static int bigDecimalCompareTo(String val, String val2) {
        return new BigDecimal(val).compareTo(new BigDecimal(val2));
    }

    public static boolean verification(String val, int i) {
        if (val == null) {
            return false;
        }
        if ("".equals(val)) {
            return false;
        }
        if (val.length() >= i) {
            return false;
        }
        return true;

    }

    public static boolean lengthVerification(String val, int i) {
        if (val == null) {
            return true;
        }
        if (val.length() >= i) {
            return false;
        }
        return true;

    }

    public static boolean imgWith(String fileName) {
        if (fileName.endsWith(".jpg")
                || fileName.endsWith(".jpeg")
                || fileName.endsWith(".bmp")
                || fileName.endsWith(".gif")
                || fileName.endsWith(".png")) {
            return true;
        }
        return false;
    }

}
