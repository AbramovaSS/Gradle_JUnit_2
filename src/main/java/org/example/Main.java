package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static String checkAccess(int age) {
        if (age > 18) {
            return "Allowed";
        } else {
            return "Denied";
        }
    }

    public static boolean isPositive(int n) {
        return (n >= 0) ? true : false;
    }

    public static String getGrade(int score) {
        if (score >= 0 && score <= 20) {
            return "E";
        } else if (score >= 21 && score <= 40) {
            return "D";
        } else if (score >= 41 && score <= 60) {
            return "C";
        } else if (score >= 61 && score <= 80) {
            return "B";
        } else if (score >= 81 && score <= 100) {
            return "A";
        } else {
            return "Error";
        }
    }

    public static String blastOff(int start) {
        String result = "";

        for (int i = start; i >= 1; i--) {
            result = result + i + " ";
        }
        result = result + "Поехали!";

        return result;

    }

    public static int sumToN(int n) {
        int sum = 0;

        for (int i = 0; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static boolean hasBug(String[] messages) {
        for (String msg : messages) {
            if (msg.equalsIgnoreCase("Bug")) {
                return true;
            }
        }
        return false;
    }

    public static String getEvenInRange(int start, int end) {
        String result = "";

        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                result = result + i + " ";
            }
        }
        return result.trim();
    }

    public static int findMax(int[] arr) {
        int max = arr[0];

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    public static String[] reverse(String[] arr) {
        String[] result = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }

        return result;
    }

    public static double calcAverage(List<Integer> list) {
        double sum = 0;

        for (int num : list) {
            sum = sum + num;
        }
        return sum / list.size();
    }

    public static List<String> removeSpecificName(List<String> list, String nameToRemove) {
        List<String> result = new ArrayList<>();

        for (String name : list) {
            if (!name.equals(nameToRemove)) {
                result.add(name);
            }
        }

        return result;
    }
}
