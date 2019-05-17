package com.msokolov;

class NumberOperations {
    static Number add(Number n1, Number n2) {
        int sumLength;
        int smallerLength;
        int biggerLength;
        int[] smallerNumDigits;
        int[] biggerNumDigits;
        if (n1.getLength() > n2.getLength()) {
            sumLength = n1.getLength();
            biggerNumDigits = n1.getDigits();
            biggerLength = n1.getLength();
            smallerLength = n2.getLength();
            smallerNumDigits = n2.getDigits();
        } else {
            sumLength = n2.getLength();
            biggerNumDigits = n2.getDigits();
            biggerLength = n2.getLength();
            smallerLength = n1.getLength();
            smallerNumDigits = n1.getDigits();
        }
        int[] n1Digits = n1.getDigits();
        int[] n2Digits = n2.getDigits();
        boolean longerLength = false;
        int c = 0;
        while (biggerLength - smallerLength - c >= 0 && biggerNumDigits[biggerLength - smallerLength - c] + smallerNumDigits[0] > 9) {
            if (c == smallerLength - 1) {
                sumLength++;
                longerLength = true;
            }
            c++;
        }
        int[] sumDigits = new int[sumLength];
        for (int i = 0; i < sumLength; i++)
            sumDigits[i] = 0;
        if (n1.getLength() == n2.getLength()) {
            if (!longerLength) {
                for (int i = sumLength - 1; i >= 0; i--)
                    sumDigits[i] = n1Digits[i] + n2Digits[i];
                for (int i = sumLength - 1; i >= 0; i--) {
                    if (sumDigits[i] > 9) {
                        sumDigits[i] = sumDigits[i] % 10;
                        sumDigits[i - 1]++;
                    }
                }
            } else {
                for (int i = sumLength - 2; i >= 0; i--)
                    sumDigits[i + 1] = n1Digits[i] + n2Digits[i];
                for (int i = sumLength - 1; i >= 0; i--) {
                    if (sumDigits[i] > 9) {
                        sumDigits[i] = sumDigits[i] % 10;
                        sumDigits[i - 1]++;
                    }
                }
            }
        } else {
            for (int i = 0; i < biggerLength; i++)
                sumDigits[i + (sumLength - biggerLength)] = biggerNumDigits[i];
            for (int i = sumLength - 1; i >= sumLength - smallerLength; i--)
                sumDigits[i] += smallerNumDigits[i - (sumLength - smallerLength)];
            for (int i = sumLength - 1; i > 0; i--) {
                if (sumDigits[i] > 9) {
                    sumDigits[i] = sumDigits[i] % 10;
                    sumDigits[i - 1]++;
                }
            }
        }
        return new Number(sumDigits);
    }
}