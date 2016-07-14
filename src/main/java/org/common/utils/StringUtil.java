package org.common.utils;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * String工具类
 * <p>
 * 记录一些常用的针对字符串的通用处理函数
 *
 * @author phb
 */
public class StringUtil extends org.apache.commons.lang3.StringUtils {
    /**
     * 取随机密码
     *
     * @return
     */
    public static String getRandomPasswd() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
    }

    /**
     * 将数组转成用cutStr隔开的字符串
     *
     * @param cutStr 分割字符串
     * @return String
     */
    public static String ArrayToStr(String[] strArray, String cutStr) {
        String res = null;
        if (strArray == null || strArray.length == 0) {
            res = null;
        } else {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < strArray.length; i++) {
                sb.append(strArray[i]);
                if (i != strArray.length - 1) {
                    sb.append(cutStr);
                }
            }
            res = sb.toString();

        }

        return res;
    }

    /**
     * 替换字符串中的html标签
     *
     * @param str
     * @return String
     * @author: phb Jul 8, 2009 2:10:34 PM
     */
    public static String htmlReplace(String str) {
        if (str != null && !"".equals(str)) {
            str =
                str.replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&#34;").replace("\'", "&#39;").trim();
        }
        return str;
    }

    /**
     * 替换换行符
     *
     * @param str 源字符串
     * @return String 将文本域换行符替换为<br/>
     * 标签 每位工程师都有保持代码优雅的义务 each engineer has a duty to keep the code elegant
     * @author: phb
     */
    public static String brReplace(String str) {
        if (str != null && !"".equals(str)) {
            str = str.replace("\r\n", "<br/>").replace("\n", "<br/>");
        }
        return str;
    }

    /**
     * 替换字符串中的javascript标签
     *
     * @param str
     * @return String
     * @author: phb
     */
    public static String jsReplace(String str) {
        if (str != null && !"".equals(str)) {
            str =
                str.replace("<script", "&lt;script").replace("</script>", "&lt;/script&gt;").trim();
        }
        return str;
    }

    /**
     * 比较字符串值是否相同(非绝对相同，宽松判断):比较会清理首尾空字符，并且空值及null判定为相同;
     *
     * @param compareStr 比较值，可为null
     * @param strs       多个字符串可为null
     * @return 均为null或所有值均相同返回true，否则返回false boolean
     * @author: phb
     */
    public static boolean isEqualByLoose(String compareStr, String... strs) {
        boolean check = false;
        if (strs != null) {
            compareStr = compareStr == null ? "" : compareStr.trim();
            for (String str : strs) {
                str = str == null ? "" : str.trim();
                if (!(check = compareStr.equals(str))) {
                    break;
                }
            }

        } else {
            check = isEmptyTrim(compareStr);
        }

        return check;
    }

    /**
     * 验证字符串类型的参数是否为空
     *
     * @param strs
     * @return boolean 多个同时为空 true
     */
    public static boolean isEmpty(String... strs) {
        boolean b = false;
        if (strs == null) {
            b = true;
        } else {
            b = true;
            for (String str : strs) {
                b = b && (str == null || "".equals(str));
            }
        }
        return b;
    }

    /**
     * 验证字符串类型的参数是否不为空
     *
     * @param strs
     * @return boolean 多个同时不为空 true
     */
    public static boolean isNotEmpty(String... strs) {
        boolean b = false;
        if (strs == null) {
            b = false;
        } else {
            b = true;
            for (String str : strs) {
                b = b && !isEmpty(str);
            }
        }
        return b;
    }

    /**
     * 验证字符串类型的参数是否为空(去除首尾空格)
     *
     * @param strs 多个同时trim后为空
     * @return boolean
     */
    public static boolean isEmptyTrim(String... strs) {
        return isEmpty(trim(strs));
    }

    /**
     * 验证字符串类型的参数是否不为空(去除首尾空格)
     *
     * @param strs 多个同时trim后不为空
     * @return boolean
     */
    public static boolean isNotEmptyTrim(String... strs) {
        return isNotEmpty(trim(strs));
    }

    /**
     * 字符串数组值trim
     *
     * @param strs
     * @return String[] 返回trim后的字符串数组
     * @author: phb
     */
    public static String[] trim(String... strs) {
        if (strs != null && strs.length > 0) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] != null) {
                    strs[i] = strs[i].trim();
                }
            }
        }
        return strs;
    }

    /**
     * 去掉html标签
     *
     * @param source 源
     * @return String
     * @author: phb
     */
    public static String removeHTML(String source) {

        if (!isEmpty(source)) {
            // 过滤所有html标签
            source = source.replaceAll("<.*?>", "");
        }
        return source;
    }

    /**
     * 去除所有的html标签
     *
     * @param input
     * @return
     */
    public static String htmlReplaceAll(String input) {
        if (input == null || input.trim().equals("")) {
            return "";
        }
        // 去掉所有html元素,
        String str = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "");
        str = str.replaceAll("/>|<", "");
        return str;
    }



    /**
     * 特殊字符过滤
     *
     * @param str 处理语句
     * @return String 特殊字符被替换或删除
     */
    public static String filterStr(String str) {
        if (str == null) {
            return null;
        }
        str = str.replace(";", "");
        str = str.replace("&", "");
        str = str.replace("<", "");
        str = str.replace(">", "");
        str = str.replace("'", "");
        str = str.replace("--", "");
        str = str.replace("/", "");
        str = str.replace("%", "");
        return str;
    }



    /**
     * 将字符串转成unicode
     *
     * @param str 待转字符串
     * @return unicode字符串
     */
    public static String unicode(String str) {
        if (isNotEmptyTrim(str)) {
            String tmp;
            char c;
            int i, j;
            StringBuffer sb = new StringBuffer();
            for (i = 0; i < str.length(); i++) {
                sb.append("\\u");
                c = str.charAt(i);

                j = (c >>> 8); // 取出高8位
                tmp = Integer.toHexString(j);
                if (tmp.length() == 1) {
                    sb.append("0");
                }
                sb.append(tmp);

                j = (c & 0xFF); // 取出低8位
                tmp = Integer.toHexString(j);
                if (tmp.length() == 1) {
                    sb.append("0");
                }
                sb.append(tmp);

            }
            str = sb.toString();
        }
        return str;
    }

    /**
     * 将unicode转为普通字符串
     *
     * @param str 待转字符串应全部为unicode
     * @return 普通字符串
     */
    public static String unUnicode(String str) {
        if (isNotEmptyTrim(str) && str.contains("\\u")) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < str.length() - 6; i += 6) {
                String strTemp = str.substring(i, i + 6);
                String value = strTemp.substring(2);
                int c = 0;
                for (int j = 0; j < value.length(); j++) {
                    char tempChar = value.charAt(j);
                    int t = 0;
                    switch (tempChar) {
                        case 'a':
                            t = 10;
                            break;
                        case 'b':
                            t = 11;
                            break;
                        case 'c':
                            t = 12;
                            break;
                        case 'd':
                            t = 13;
                            break;
                        case 'e':
                            t = 14;
                            break;
                        case 'f':
                            t = 15;
                            break;
                        default:
                            t = tempChar - 48;
                            break;
                    }

                    c += t * ((int) Math.pow(16, (value.length() - j - 1)));
                }
                sb.append((char) c);
            }
            str = sb.toString();
        }
        return str;
    }

    /**
     * 将对象转成Double
     *
     * @param value
     * @return
     */
    public static Double toDouble(Object value) {
        double val = 0.0;
        if (value != null && String.valueOf(value).trim().length() > 0) {
            if (value instanceof Double) {
                val = ((Double) value).doubleValue();
            } else if (value instanceof Float) {
                val = ((Float) value).doubleValue();
            } else if (value instanceof String) {
                if (((String) value).contains("∞")) {
                    val = 0.0;
                } else {
                    val = Double.parseDouble((String) value);
                }
            } else {
                val = Double.valueOf(String.valueOf(value));
            }
        }
        return val;
    }

    /**
     * 根据换算公式， 计算出所有单位与核算单位之间的换算量
     * <p>
     * <br>
     * 例如:<br>
     * calcUnitsRelation ( [ {unit_id1 : 'unit_package', unit_id2 : 'unit_kg', unit_conversion : 2.0},
     * {unit_id1 : 'unit_kg', unit_id2 : 'unit_piece', unit_conversion : 5}, {unit_id1 :
     * 'unit_package', unit_id2 : 'unit_gram', unit_conversion : 1000} ], 'unit_gram');
     * <p>
     * <br>
     * 输出: {unit_gram: 1, unit_package: 1000, unit_kg: 500, unit_piece: 100}
     *
     * @param formulas    换算公式链表 每个公式格式: {unit_id1 : 'unit_package', unit_id2 : 'unit_kg',
     *                    unit_conversion : 2.0}
     * @param checkUnitId 物料核算单位
     * @returns Map 所有单位与核算单位之间的换算量
     */
    public static Map<Integer, Double> calcUnitsRelation(List<Map<Integer, Object>> formulas, Integer checkUnitId) {
        // 遍历所有单位
        ArrayList<Integer> uids = new ArrayList<Integer>();
        for (Map<Integer, Object> map : formulas) {
            Integer unit_id1 = Integer.valueOf(map.get("unit_id1").toString());
            Integer unit_id2 = Integer.valueOf(map.get("unit_id2").toString());
            if (!uids.contains(unit_id1))
                uids.add(unit_id1);
            if (!uids.contains(unit_id2))
                uids.add(unit_id2);
        }
        // 核算单位不在公式列表中， 退出
        if (!uids.contains(checkUnitId))
            return null;
        // 根据拓扑关系， 计算出所有单位与核算单位之间的换算量
        Map<Integer, Double> dict = new HashMap<Integer, Double>();
        dict.put(checkUnitId, 1.);
        for (@SuppressWarnings("unused") Integer uid : uids) {
            for (Map<Integer, Object> map : formulas) {
                Integer unit_id1 = Integer.valueOf(map.get("unit_id1").toString());
                Integer unit_id2 = Integer.valueOf(map.get("unit_id2").toString());
                Double conversion = StringUtil.toDouble(map.get("unit_conversion"));
                if (!dict.containsKey(unit_id1) && dict.containsKey(unit_id2)) {
                    dict.put(unit_id1, dict.get(unit_id2) * conversion);
                }
                if (dict.containsKey(unit_id1) && !dict.containsKey(unit_id2)) {
                    dict.put(unit_id2, dict.get(unit_id1) / conversion);
                }
            }
        }
        // 成功校验
        for (Integer uid : uids) {
            if (!dict.containsKey(uid))
                return null;
        }
        return dict;
    }
}
