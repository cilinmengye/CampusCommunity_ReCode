package com.campuscommunitybacked.utils;

import java.util.ArrayList;
import java.util.List;

public class TransformUtil {
    public static String listToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static List<String> stringToList(String str) {
        List<String> list = new ArrayList<String>();
        String[] strs = str.split(",");
        for (int i = 0; i < strs.length; i++) {
            list.add(strs[i]);
        }
        return list;
    }
}
