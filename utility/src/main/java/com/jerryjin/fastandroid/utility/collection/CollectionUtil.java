package com.jerryjin.fastandroid.utility.collection;

import android.support.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionUtil {

    @Nullable
    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(@Nullable List<T> tList, Class<T> tClass) {
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

    @Nullable
    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(@Nullable Set<T> tSet, Class<T> tClass) {
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

    @Nullable
    public static <T> HashSet<T> toHashSet(@Nullable T[] array) {
        if (array == null || array.length == 0)
            return null;
        HashSet<T> set = new HashSet<>();
        Collections.addAll(set, array);
        return set;
    }

    @Nullable
    public static <T> ArrayList<T> toArrayList(@Nullable T[] array) {
        if (array == null || array.length == 0) {
            return null;
        } else {
            ArrayList<T> arrayList = new ArrayList<>();
            Collections.addAll(arrayList, array);
            return arrayList;
        }
    }
}
