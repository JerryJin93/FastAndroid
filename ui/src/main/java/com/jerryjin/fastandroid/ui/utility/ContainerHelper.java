package com.jerryjin.fastandroid.ui.utility;

/**
 * Author: Jerry
 * Generated at: 2019/2/18 13:36
 * WeChat: enGrave93
 * Description:
 */
@SuppressWarnings({"WeakerAccess", "BooleanMethodIsAlwaysInverted"})
public class ContainerHelper {


    /**
     *  To make sure whether the given position is at the brink of the array or matrix.
     *
     *  The matrix for example:
     *  <p>
     *  0 1 2 3
     *  <p>
     *  4 5 6 7
     *  <p>
     *  8 9 0 1
     *  <p>
     * 2 3 4 5
     *
     * @param columnLen The column width.
     * @param position  The position to check.
     * @param size      The array size.
     * @return True if either at the start or at the end of the array or matrix, false otherwise.
     * @throws IllegalArgumentException Check whether the position is legal or not.
     */
    public static boolean isAtBrink(int columnLen, int position, int size) throws IllegalArgumentException {
        boolean result;
        if (position >= 0 && position < size) {
            // if size is 13 and the columnLen is 4, the rest will be 1(minimum increment). And the rows is calculated as 4.
            int rows = size % columnLen == 0 ? size / columnLen : size / columnLen + 1;
            int[] starts = getStartIndexes(columnLen, rows, size);
            int[] ends = getEndIndexes(columnLen, rows, size);
            result = contains(starts, position) || contains(ends, position);
        } else {
            throw new IllegalArgumentException("The given position is out of range, retry is in need.");
        }
        return result;
    }

    public static boolean isAtLeftBrink(int columnLen, int position, int size) throws IllegalArgumentException {
        boolean result;
        if (position >= 0 && position < size) {
            // if size is 13 and the columnLen is 4, the rest will be 1(minimum increment). And the rows is calculated as 4.
            int rows = size % columnLen == 0 ? size / columnLen : size / columnLen + 1;
            int[] starts = getStartIndexes(columnLen, rows, size);
            result = contains(starts, position);
        } else {
            throw new IllegalArgumentException("The given position is out of range, retry is in need.");
        }
        return result;
    }

    public static boolean isAtRightBrink(int columnLen, int position, int size) throws IllegalArgumentException {
        boolean result;
        if (position >= 0 && position < size) {
            // if size is 13 and the columnLen is 4, the rest will be 1(minimum increment). And the rows is calculated as 4.
            int rows = size % columnLen == 0 ? size / columnLen : size / columnLen + 1;
            int[] ends = getEndIndexes(columnLen, rows, size);
            result = contains(ends, position);
        } else {
            throw new IllegalArgumentException("The given position is out of range, retry is in need.");
        }
        return result;
    }

    public static int[] getStartIndexes(int columnLen, int rows, int size) {
        int[] arr = new int[rows];
        for (int i = 0; i < rows; i++) {
            arr[i] = i * columnLen;
        }
        return arr;
    }

    public static int[] getEndIndexes(int columnLen, int rows, int size) {
        int[] arr = new int[rows];
        for (int i = 0; i < rows; i++) {
            if (i == rows - 1) {
                arr[i] = size % columnLen - 1;
            } else {
                arr[i] = columnLen * (i + 1) - 1;
            }
        }
        return arr;
    }

    public static boolean contains(Object[] objects, Object object) {
        boolean result = false;
        for (Object obj : objects) {
            if (obj.equals(object)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean contains(int[] ints, int value) {
        boolean result = false;
        for (int i : ints) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean contains(byte[] bytes, byte value) {
        boolean result = false;
        for (byte b : bytes) {
            if (b == value) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean contains(short[] shorts, short value) {
        boolean result = false;
        for (short s : shorts) {
            if (s == value) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean contains(float[] floats, float value) {
        boolean result = false;
        for (float f : floats) {
            if (f == value) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean contains(double[] doubles, double value) {
        boolean result = false;
        for (double d : doubles) {
            if (d == value) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean contains(long[] longs, long value) {
        boolean result = false;
        for (long l : longs) {
            if (l == value) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean contains(char[] characters, char value) {
        boolean result = false;
        for (char character : characters) {
            if (character == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
