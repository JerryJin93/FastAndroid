package com.jerryjin.fastandroid.utility.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringMan {

    private static final char[] DICTIONARY = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private String stringMan;

    public StringMan() {
        super();
    }

    public StringMan(String stringMan) {
        this.stringMan = stringMan;
    }

    public StringMan(byte[] bytes) {
        stringMan = new String(bytes);
    }

    public StringMan(StringBuffer buffer) {
        stringMan = new String(buffer);
    }

    public StringMan(StringBuilder builder) {
        stringMan = new String(builder);
    }

    public StringMan(String[] strings) {
        append(strings);
    }

    public StringMan(List<String> stringList) {
        append(stringList);
    }

    public StringMan(StringMan stringMan) {
        setStringMan(stringMan.toString());
    }

    public StringMan(boolean b) {
        setStringMan(String.valueOf(b));
    }

    public StringMan(char c) {
        setStringMan(String.valueOf(c));
    }

    public StringMan(byte b) {
        setStringMan(String.valueOf(b));
    }

    public StringMan(int i) {
        setStringMan(String.valueOf(i));
    }

    public StringMan(float f) {
        setStringMan(String.valueOf(f));
    }

    public StringMan(double d) {
        setStringMan(String.valueOf(d));
    }

    public static char charAt(String string, int index) {
        return string.charAt(index);
    }

    //OK
    public static int[] getAllIndexes(String origin, String str) {
        return new StringMan(origin).allIndexesOf(str);
    }

    public static int[] getAllIndexes(String origin, String str, boolean sensitive) {
        return new StringMan(origin).allIndexesOf(str, sensitive);
    }

    public static int firstIndex(String origin, String substring) {
        return origin.indexOf(substring);
    }

    //OK

    public static int lastIndex(String orgin, String substring) {
        return orgin.lastIndexOf(substring);
    }

    /**
     * Generates a string by picking random character from the dictionary.
     *
     * @param length The length of the string to generate.
     * @return Generated string.
     */
    public static String getRandomString(int length) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            builder.append(DICTIONARY[random.nextInt(DICTIONARY.length)]);
        }
        return builder.toString();
    }

    public static String appendArray(String... strings) {
        StringBuilder builder = new StringBuilder();
        for (String str : strings) {
            builder.append(str);
        }
        return builder.toString();
    }

    public static String append(String original, String[] strings) {
        return original + new StringMan().stringOf(strings);
    }

    public static StringMan deleteString(String origin, String toDelete) {
        return new StringMan(origin).deleteString(toDelete);
    }

    public static String delete(String origin, int start, int end) {
        return new StringMan(origin).delete(start, end).toString();
    }

    public static String reverse(String stringMan) {
        return new StringBuilder(stringMan).reverse().toString();
    }

    /**
     * Surrounds a string with prefix and suffix.
     *
     * @param origin The origin string you want to process.
     * @param prefix The prefix string you want to insert.
     * @param suffix The suffix string you want to insert.
     * @return Processed string.
     */
    public static String surround(String origin, String prefix, String suffix) {
        return new StringMan(origin).surround(prefix, suffix).toString();
    }

    public static String surroundAll(String origin, String strToSurround, String prefix, String suffix) {
        return new StringMan(origin).surroundAll(strToSurround, prefix, suffix).toString();
    }

    public static String detachSurround(String origin, String prefix, String suffix) {
        return new StringMan(origin).detachSurround(prefix, suffix).toString();
    }

    public static String detachAllSurrounds(String origin, String prefix, String suffix) {
        return new StringMan(origin).detachAllSurrounds(prefix, suffix).toString();
    }

    public static boolean isEnclosedBy(String origin, String prefix, String suffix) {
        return new StringMan(origin).isEnclosedBy(prefix, suffix);
    }

    public static String getComplementary(String s1, String s2) {
        return new StringMan(s1).getComplementaryOf(s2).toString();
    }

    public static char[] toCharArray(String origin) {
        return origin.toCharArray();
    }

    public static String[] toStringArray(String origin) {
        return new StringMan(origin).toStringArray();
    }

    public static String shuffle(String origin) {
        return new StringMan(origin).shuffle().toString();
    }

    public static int[] randomIndex(int len) {
        int[] randomIndex = new int[len];
        List<Integer> tmpIndexList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < len; i++) {
            tmpIndexList.add(i);
        }

        for (int i = 0; i < randomIndex.length; i++) {
            int tmp = random.nextInt(len--);
            randomIndex[i] = tmpIndexList.get(tmp);
            tmpIndexList.remove(tmp);
        }

        return randomIndex;
    }

    public static boolean intArrayHasSameNumbers(int[] array) {
        boolean b = false;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    b = true;
                    break;
                }
            }
            if (b) {
                break;
            }
        }
        return b;
    }

    private static int firstSameIndexOfIntArray(int[] array) {
        int index = -1;
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    flag = true;
                    index = i;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        return index;
    }

    public static boolean intArrayHasDifferentNumbers(int[] array) {
        boolean b = false;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] != array[j]) {
                    b = true;
                    break;
                }
            }
            if (b) {
                break;
            }
        }
        return b;
    }

    public static int[] trimIntArray(int[] array) {
        int[] tmp = array;
        int[] result;
        List<Integer> integers;
        try {
            integers = intArrayToList(array, 0, array.length - 1);
            while (intArrayHasSameNumbers(tmp)) {
                int index = firstSameIndexOfIntArray(tmp);
                if (index != -1) {
                    integers.remove(index);
                    tmp = integerListToArray(integers);
                }
            }
            result = integerListToArray(integers);
            return result;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Integer> intArrayToList(int[] intArray, int start, int end) throws IndexOutOfBoundsException {
        if ((start >= 0) && (start <= intArray.length - 1) && ((end >= 0) && (end <= intArray.length - 1))) {
            List<Integer> integers = new ArrayList<>();
            if (start > end) {
                int tmp = start;
                start = end;
                end = tmp;
            }
            for (int i = start; i <= end; i++) {
                integers.add(intArray[i]);
            }
            return integers;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public static int[] integerListToArray(List<Integer> integerList) {
        if (integerList != null) {
            int[] array = new int[integerList.size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = integerList.get(i);
            }
            return array;
        } else {
            return null;
        }
    }

    /**
     * Returns true if and only if the one specific string contains another specific string.
     *
     * @param s1 The specific string to check.
     * @param s2 The specific string to search for.
     * @return True if s1 contains s2, false otherwise.
     */
    public static boolean contains(String s1, String s2) {
        return s1.contains(s2);
    }

    /**
     * Returns true if and only if the s1 contains another specific string under the condition of its sensitivity.
     *
     * @param s1        The specific string to check.
     * @param s2        The string to search for.
     * @param sensitive The specific string is either sensitive to the upper/lower case or not.
     * @return True if s1 contains s2, false otherwise.
     */
    public static boolean contains(String s1, String s2, boolean sensitive) {
        return new StringMan(s1).contains(s2, sensitive);
    }

    /**
     * Returns true if and only if the string contains all the strings in a specific array.
     *
     * @param string  The specific string to check.
     * @param strings The string array to search for.
     * @return True if string contains all the strings in the array, false otherwise.
     */
    public static boolean containsAll(String string, String[] strings) {
        return new StringMan(string).containsAll(strings);
    }

    /**
     * Returns true if and only if the string contains all the strings in a specific array in terms of its items' sensitivity.
     *
     * @param string    The specific string to check.
     * @param strings   The string array to search to search for.
     * @param sensitive All of the strings in the specific array are either sensitive to upper/lower case or not.
     * @return True if string contains all the strings in the array, false otherwise.
     */
    public static boolean containsAll(String string, String[] strings, boolean sensitive) {
        return new StringMan(string).containsAll(strings, sensitive);
    }

    /**
     * Returns true if and only if the string contains any string in a specific array.
     *
     * @param string  The specific string to check.
     * @param strings The string array to search for.
     * @return True if string contains any string in the array, false otherwise.
     */
    public static boolean containsAny(String string, String[] strings) {
        return new StringMan(string).containsAny(strings);
    }

    /**
     * Returns true if and only if the string contains any string in a specific array in terms of its items' sensitivity.
     *
     * @param string    The specific string to check.
     * @param strings   The string array to search for.
     * @param sensitive All of the strings in the specific array are either sensitive to upper/lower case or not.
     * @return True if string contains any string in the array, false otherwise.
     */
    public static boolean containsAny(String string, String[] strings, boolean sensitive) {
        return new StringMan(string).containsAny(strings, sensitive);
    }

    public static int countSubstring(String origin, String substring) {
        return getAllIndexes(origin, substring).length;
    }

    public static int countSubstring(String origin, String substring, boolean sensitive) {
        return getAllIndexes(origin, substring, sensitive).length;
    }

    public static String getStringBetween(String origin, String identifier1, String identifier2) {
        return new StringMan(origin).stringBetween(identifier1, identifier2);
    }

    public static String paddingLeft(String origin, String toInsert, int num) {
        return new StringMan(origin).paddingLeft(toInsert, num).toString();
    }

//    public static String toCamelCase(String origin){
//
//    }

    public static String paddingRight(String origin, String toInsert, int num) {
        return new StringMan(origin).paddingRight(toInsert, num).toString();
    }

    public static String removeNonWords(String origin) {
        return new StringMan(origin).removeNonWords().toString();
    }

    public static String replace(String origin, String old, String replacer) {
        return new StringMan(origin).replace(old, replacer).toString();
    }

    public static String replace(String origin, int start, int end, String replacer) {
        return new StringMan(origin).replace(start, end, replacer).toString();
    }

    public static String trim(String str) {
        return str.trim();
    }

    public static String trimEmptyLines(String origin) {
        return new StringMan(origin).trimEmptyLines().toString();
    }

    public static String deleteSpaces(String origin) {
        return new StringMan(origin).deleteSpaces().toString();
    }

    public static String shrinkSpaces(String origin) {
        return new StringMan(origin).shrinkSpaces().toString();
    }

    public static String shrinkEmptyLines(String origin) {
        return new StringMan(origin).shrinkEmptyLines().toString();
    }

    /**
     * Returns a string made up of num substrings.
     *
     * @param str The substring to clone.
     * @param num The number of the specific substring.
     * @return A string made up of num substrings.
     */
    public static String getConsecutive(String str, int num) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            builder.append(str);
        }
        return builder.toString();
    }

    public static String getStars(int num) {
        return getConsecutive("*", num);
    }

    public static String getDashes(int num) {
        return getConsecutive("-", num);
    }

//    public String encode(){
//        Random random = new Random();
//        pattern = new int[random.nextInt(stringMan.length())];
//        for (int i = 0; i < pattern.length; i++){
//            pattern[i] = random.nextInt(stringMan.length());
//            insert(pattern[i], getRandomString(pattern[i]));
//        }
//        return stringMan;
//    }

    public String getStringMan() {
        return stringMan;
    }

    public void setStringMan(String stringMan) {
        this.stringMan = stringMan;
    }

    public char charAt(int index) {
        return stringMan.charAt(index);
    }

    /**
     * Gets all indexes of the specific string.
     *
     * @param str The string which you want to look up for all its indexes.
     * @return An array of all indexes.
     * @throws NullPointerException Throws exception when this.stringMan is null.
     */
    public int[] allIndexesOf(String str) throws NullPointerException {
        List<Integer> indexesList = new ArrayList<>();
        int index = stringMan.indexOf(str);
        while (index != -1) {
            indexesList.add(index);
            index = stringMan.indexOf(str, index + 1);
        }
        int[] indexes = new int[indexesList.size()];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = indexesList.get(i);
        }
        return indexes;
    }

    public int[] allIndexesOf(String str, boolean sensitive) {
        if (sensitive) {
            return allIndexesOf(str);
        } else {
            List<Integer> indexesList = new ArrayList<>();
            int index = stringMan.toLowerCase().indexOf(str.toLowerCase());
            while (index != -1) {
                indexesList.add(index);
                index = stringMan.toLowerCase().indexOf(str.toLowerCase(), index += str.length());
            }
            int[] indexes = new int[indexesList.size()];
            for (int i = 0; i < indexes.length; i++) {
                indexes[i] = indexesList.get(i);
            }
            return indexes;
        }
    }

    public int firstIndexOf(String str) {
        return stringMan.indexOf(str);
    }

    public int lastIndexOf(String str) {
        return stringMan.lastIndexOf(str);
    }

    public StringMan append(String str) {
        if (stringMan != null) {
            setStringMan(new StringBuilder(stringMan).append(str).toString());
        } else {
            setStringMan(str);
        }
        return this;
    }

    public StringMan append(boolean b) {
        this.append(String.valueOf(b));
        return this;
    }

    public StringMan append(char c) {
        this.append(String.valueOf(c));
        return this;
    }

    public StringMan append(int i) {
        this.append(String.valueOf(i));
        return this;
    }

    public StringMan append(float f) {
        this.append(String.valueOf(f));
        return this;
    }

    public StringMan append(double d) {
        this.append(String.valueOf(d));
        return this;
    }

    public StringMan append(StringMan stringMan) {
        this.append(stringMan.toString());
        return this;
    }

    public StringMan append(String[] strings) {
        String str = stringOf(strings);
        this.append(str);
        return this;
    }

    public StringMan appendMultiple(String... strings) {
        String str = stringOf(strings);
        this.append(str);
        return this;
    }

    public StringMan append(List<String> stringList) {
        for (String s : stringList) {
            append(s);
        }
        return this;
    }

    public StringMan insert(int offset, String str) {
        if (stringMan != null) {
            setStringMan(new StringBuilder(stringMan).insert(offset, str).toString());
        } else {
            setStringMan(str);
        }
        return this;
    }

    public StringMan insert(int offset, String toInsert, int num) {
        StringMan stringMan = new StringMan();
        for (int i = 0; i < num; i++) {
            stringMan.append(toInsert);
        }
        insert(offset, stringMan.toString());
        return this;
    }

    public StringMan insertArray(int offset, String[] strings) {
        String str = stringOf(strings);
        this.insert(offset, str);
        return this;
    }

    public String stringOf(String[] strings) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            builder.append(strings[i]);
        }
        return builder.toString();
    }

    public StringMan deleteString(String toDelete) {
        try {
            StringBuilder builder = new StringBuilder(stringMan);
            int[] indexes = allIndexesOf(toDelete);
            for (int i = 0; i < indexes.length; i++) {
                builder.delete(indexes[i], indexes[i] + toDelete.length());
                if (i + 1 < indexes.length) {
                    indexes[i + 1] -= toDelete.length() * (i + 1);
                }
            }
            setStringMan(builder.toString());
        } catch (NullPointerException e) {
            //e.printStackTrace();
        }
        return this;
    }

    public StringMan delete(int start, int end) {
        if (stringMan != null) {
            StringBuilder builder = new StringBuilder(stringMan);
            builder.delete(start, end);
            setStringMan(builder.toString());
        }
        return this;
    }

    public StringMan clear() {
        setStringMan("");
        return this;
    }

    public int length() {
        return stringMan.length();
    }

    /**
     * Reverse the string field of a StringMan.
     *
     * @return Reversed StringMan.
     */
    public StringMan reverse() {
        if (stringMan != null) {
            setStringMan(new StringBuilder(stringMan).reverse().toString());
        }
        return this;
    }

    /**
     * Get the substring of stringMan.
     *
     * @param start Inclusive.
     * @param end   Exclusive.
     * @return The substring from start to end.
     */
    public StringMan subString(int start, int end) {
        if (stringMan != null) {
            setStringMan(stringMan.substring(start, end));
        }
        return this;
    }

    /**
     * @param prefix The prefix string you want to insert.
     * @param suffix The suffix string you want to insert.
     * @return Current StringMan object that has been processed.
     */
    public StringMan surround(String prefix, String suffix) {
        if (stringMan != null) {
            setStringMan(new StringBuilder(stringMan).insert(0, prefix).append(suffix).toString());
        } else {
            setStringMan(prefix + suffix);
        }
        return this;
    }

    public StringMan surroundAll(String strToSurround, String prefix, String suffix) {
        if (stringMan != null) {
            int[] indexes = allIndexesOf(strToSurround);
            StringBuilder builder = new StringBuilder(stringMan);
            for (int i = 0; i < indexes.length; i++) {
                builder.insert(indexes[i], prefix);
                indexes[i] += prefix.length();
                builder.insert(indexes[i] + strToSurround.length(), suffix);
                indexes = getAllIndexes(builder.toString(), strToSurround);
            }
            setStringMan(builder.toString());
        } else {
            setStringMan(prefix + suffix);
        }
        return this;
    }

    public StringMan detachSurround(String prefix, String suffix) {
        if (stringMan != null) {
            if (stringMan.startsWith(prefix)) {
                delete(0, prefix.length());
            }
            if (stringMan.endsWith(suffix)) {
                int indexOfSuffix = stringMan.lastIndexOf(suffix);
                delete(indexOfSuffix, indexOfSuffix + suffix.length());
            }
        }
        return this;
    }

    /**
     * Detach all specific surrounds of current object's string value.
     *
     * @param prefix The prefix string you want to detach.
     * @param suffix The suffix string you wang to detach.
     * @return Current object after being processed.
     */
    public StringMan detachAllSurrounds(String prefix, String suffix) {
        if (stringMan != null) {
            int[] indexesPrefix = allIndexesOf(prefix);
            int[] indexesSuffix = allIndexesOf(suffix);
            StringBuilder builder = new StringBuilder(stringMan);
            if (indexesPrefix.length != 0) {
                for (int i = 0; i < indexesPrefix.length; i++) {
                    builder.delete(indexesPrefix[i], indexesPrefix[i] + prefix.length());
                    if (i + 1 < indexesPrefix.length) {
                        indexesPrefix[i + 1] -= prefix.length() * (i + 1);
                    }
                }
                setStringMan(builder.toString());
            }
            if (indexesSuffix.length != 0) {
                indexesSuffix = getAllIndexes(builder.toString(), suffix);
                for (int i = 0; i < indexesSuffix.length; i++) {
                    builder.delete(indexesSuffix[i], indexesSuffix[i] + suffix.length());
                    if (i + 1 < indexesSuffix.length) {
                        indexesSuffix[i + 1] -= suffix.length() * (i + 1);
                    }
                }
                setStringMan(builder.toString());
            }
        }
        return this;
    }

    public boolean isEnclosedBy(String prefix, String suffix) {
        if (stringMan == null) {
            throw new IllegalArgumentException("The stringMan itself can't be null.");
        }
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix can't be empty.");
        }
        if (suffix == null) {
            throw new IllegalArgumentException("Suffix can't be empty.");
        }
        return stringMan.startsWith(prefix) && stringMan.endsWith(suffix);
    }

    public boolean isEnclosedBy(String surround) {
        return isEnclosedBy(surround, surround);
    }

    public StringMan getComplementaryOf(String string) {
        if (stringMan != null && !stringMan.equals("")) {
            if (string != null && !string.equals("")) {
                if (stringMan.length() >= string.length()) {
                    if (stringMan.contains(string)) {
                        setStringMan(deleteString(string).toString());
                    } else {
                        setStringMan(null);
                    }
                } else {
                    if (string.contains(stringMan)) {
                        setStringMan(deleteString(string, stringMan).toString());
                    } else {
                        setStringMan(null);
                    }
                }
            }
        } else {
            setStringMan(string);
        }
        return this;
    }

    public char[] toCharArray() {
        if (stringMan != null) {
            char[] chars = stringMan.toCharArray();
            return chars;
        } else {
            return null;
        }
    }

    public String[] toStringArray() {
        if (stringMan != null) {
            char[] chars = stringMan.toCharArray();
            String[] array = new String[chars.length];
            for (int i = 0; i < array.length; i++) {
                array[i] = chars[i] + "";
            }
            return array;
        } else {
            return null;
        }
    }

    public StringMan shuffle() {
        if (stringMan != null) {
            char[] chars = stringMan.toCharArray();
            int[] randomIndex = randomIndex();
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < stringMan.length(); i++) {
                builder.append(chars[randomIndex[i]]);
            }
            setStringMan(builder.toString());
        }
        return this;
    }

    public int[] randomIndex() {
        if (stringMan != null) {
            int len = stringMan.length();
            int[] randomIndex = new int[stringMan.length()];
            List<Integer> tmpIndexList = new ArrayList<>();
            Random random = new Random();

            for (int i = 0; i < stringMan.length(); i++) {
                tmpIndexList.add(i);
            }

            for (int i = 0; i < randomIndex.length; i++) {
                int tmp = random.nextInt(len--);
                randomIndex[i] = tmpIndexList.get(tmp);
                tmpIndexList.remove(tmp);
            }

            return randomIndex;
        } else {
            return null;
        }
    }

    private int randomInt(int start, int end) {
        Random random = new Random();
        int randomInt = random.nextInt(end);
        while (randomInt < start) {
            randomInt = random.nextInt(end);
        }
        return randomInt;
    }

    /**
     * Returns true if and only if the stringMan contains another specific string.
     *
     * @param string The specific string to search for.
     * @return True if stringMan contains string, false otherwise.
     */
    public boolean contains(String string) {
        return stringMan.contains(string);
    }

    /**
     * Returns true if and only if the stringMan contains another specific string under the condition of its sensitivity.
     *
     * @param string    The string to search for.
     * @param sensitive The specific string is either sensitive to the upper/lower case or not.
     * @return True if stringMan contains string, false otherwise.
     */
    public boolean contains(String string, boolean sensitive) {
        if (sensitive) {
            return stringMan.contains(string);
        } else {
            return stringMan.toLowerCase().contains(string.toLowerCase());
        }
    }

    /**
     * Returns true if and only if the stringMan contains all the strings in a specific array.
     *
     * @param strings The string array to search for.
     * @return True if stringMan contains all the strings in the array, false otherwise.
     */
    public boolean containsAll(String[] strings) {
        int len = strings.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (stringMan.contains(strings[i])) {
                count++;
            }
        }
        return len == count;
    }

    /**
     * Returns true if and only if the stringMan contains all the strings in a specific array in terms of its items' sensitivity.
     *
     * @param strings   The string array to search for.
     * @param sensitive All of the strings in the specific array are either sensitive to upper/lower case or not.
     * @return True if stringMan contains all the strings in the array, false otherwise.
     */
    public boolean containsAll(String[] strings, boolean sensitive) {
        if (sensitive) {
            return containsAll(strings);
        } else {
            int len = strings.length;
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (stringMan.toLowerCase().contains(strings[i].toLowerCase())) {
                    count++;
                }
            }
            return len == count;
        }
    }

    /**
     * Returns true if and only if the stringMan contains any string in a specific array.
     *
     * @param strings The string array to search for.
     * @return True if stringMan contains any string in the array, false otherwise.
     */
    public boolean containsAny(String[] strings) {
        int len = strings.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (stringMan.contains(strings[i])) {
                count++;
                break;
            }
        }
        if (count != 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns true if and only if the stringMan contains any string in a specific array in terms of its items' sensitivity.
     *
     * @param strings   The string array to search for.
     * @param sensitive All of the strings in the specific array are either sensitive to upper/lower case or not.
     * @return True if stringMan contains any string in the array, false otherwise.
     */
    public boolean containsAny(String[] strings, boolean sensitive) {
        if (sensitive) {
            return containsAny(strings);
        } else {
            int len = strings.length;
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (stringMan.toLowerCase().contains(strings[i].toLowerCase())) {
                    count++;
                    break;
                }
            }
            if (count != 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public int countSubstring(String substring) {
        return allIndexesOf(substring).length;
    }

    public int countSubstring(String substring, boolean sensitive) {
        return allIndexesOf(substring, sensitive).length;
    }

    public String stringBetween(String identifier1, String identifier2) {
        if (stringMan != null && stringMan.length() > 0) {
            int firstIndex = firstIndex(stringMan, identifier1);
            int lastIndex = lastIndex(stringMan, identifier2);
            StringMan stringMan = new StringMan();
            String[] strings = toStringArray(this.stringMan.substring(firstIndex, lastIndex + 1));
            stringMan.append(strings[0]);
            for (String s : strings) {
                if (s.matches("\\w")) {
                    stringMan.append(s);
                }
            }
            stringMan.append(strings[strings.length - 1]);
            return stringMan.toString();
        } else {
            return null;
        }
    }

    public StringMan paddingLeft(String toInsert, int num) {
        return insert(0, toInsert, num);
    }

    public StringMan paddingRight(String toInsert, int num) {
        return insert(stringMan.length(), toInsert, num);
    }

    public StringMan removeNonWords() {
        StringMan stringMan = new StringMan();
        String[] strings = toStringArray();
        for (String s : strings) {
            if (s.matches("\\w")) {
                stringMan.append(s);
            }
        }
        setStringMan(stringMan.toString());
        return this;
    }

    public StringMan replace(String old, String replacer) {
        setStringMan(stringMan.replace(old, replacer));
        return this;
    }

    public StringMan replace(int start, int end, String replacer) {
        setStringMan(new StringBuilder(stringMan).replace(start, end, replacer).toString());
        return this;
    }

    public boolean startsWith(String prefix) {
        return stringMan.startsWith(prefix);
    }

    public boolean startsWith(String prefix, int offset) {
        return stringMan.startsWith(prefix, offset);
    }

    public boolean endsWith(String suffix) {
        return stringMan.endsWith(suffix);
    }

    public StringMan trim() {
        setStringMan(stringMan.trim());
        return this;
    }

    public StringMan trimEmptyLines() {

        while (startsWith("\n") || endsWith("\n")) {
            detachSurround("\n", "\n");
        }

        return this;
    }

    public StringMan deleteSpaces() {
//        StringMan stringMan = new StringMan(getStringMan().split("\\s+"));
//        setStringMan(stringMan.toString());
        deleteString(" ");
        return this;
    }

    public StringMan shrinkSpaces() {
        trim();
        setStringMan(stringMan.replaceAll("\\s\\s+", " "));
        return this;
    }

    public StringMan shrinkEmptyLines() {
        trimEmptyLines();
        setStringMan(stringMan.replaceAll("\n\n+", "\n"));
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            if (o.getClass() == String.class) {
                return stringMan.equals(o);
            } else {
                return false;
            }
        } else {
            return stringMan.equals(o.toString());
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return stringMan;
    }
}

