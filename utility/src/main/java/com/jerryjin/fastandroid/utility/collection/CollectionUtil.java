package com.jerryjin.fastandroid.utility.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionUtil {

    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(List<T> tList, Class<T> tClass) {
        if (tList == null || tList.size() == 0) {
            return null;
        } else {
            int size = tList.size();
            try {
                T[] array = (T[]) Array.newInstance(tClass, size);
                return tList.toArray(array);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(Set<T> tSet, Class<T> tClass) {
        if (tSet == null || tSet.size() == 0) {
            return null;
        } else {
            int size = tSet.size();
            try {
                T[] array = (T[]) Array.newInstance(tClass, size);
                return tSet.toArray(array);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static <T> HashSet<T> toHashSet(T[] array) {
        if (array == null || array.length == 0)
            return null;
        HashSet<T> set = new HashSet<>();
        Collections.addAll(set, array);
        return set;
    }

    public static <T> ArrayList<T> toArrayList(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        } else {
            ArrayList<T> arrayList = new ArrayList<>();
            Collections.addAll(arrayList, array);
            return arrayList;
        }
    }
}
