package com.msokolov;

public class Number {

    private byte[] digits;
    private int length;

    Number(int[] numberDigits) {
        digits = intToByteDigitArray(numberDigits);
        length = digits.length;
    }

    Number(String strDigits) {
        int[] intArr = convertStringToIntArray(strDigits);
        digits = intToByteDigitArray(intArr);
        length = digits.length;
    }

    int[] getDigits() {
        return byteToIntArray(digits);
    }

    int getLength() {
        return length;
    }

    private int[] convertStringToIntArray(String str) {
        int[] digits = new int[str.length()];
        for (int i = 0; i < digits.length; i++) {
            String s = String.valueOf(str.charAt(i));
            int d = Integer.parseInt(s);
            if (d < 10)
                digits[i] = (byte) d;
            else
                digits[i] = -1;
        }
        return digits;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (byte b : digits) {
            str.append(String.valueOf(b));
        }
        return str.toString();
    }

    private int[] byteToIntArray(byte[] arr) {
        int[] intArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = arr[i];
        }
        return intArr;
    }

    private byte[] intToByteDigitArray(int[] arr) {
        byte[] newArr = new byte[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 10)
                newArr[i] = (byte) arr[i];
            else
                newArr[i] = -1;
        }
        return newArr;
    }
}
