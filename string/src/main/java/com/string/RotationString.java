package com.string;

public class RotationString {
    public static void main(String[] args) {
        System.out.println(new RotationString().isRotationStrs("12254", 5, "22541", 5));
    }

    public boolean isRotationStrs(String a, int lena, String b, int lenb) {
        if (lena != lenb) return false;
        if (lena <= 0) return false;
        return (a + a).contains(b);
    }
}
