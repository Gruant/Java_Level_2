package ru.grutsinav;

import java.util.Arrays;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        System.out.println("Время выполения метода без потоков: " + methodOne(fillArray(initArray(size)))
                + " мc");

        System.out.println("Время выполения метода без потоков: " + methodTwo(fillArray(initArray(size)))
                + " мc");
    }

    public static float[] initArray(int size){
        return new float[size];
    }

    public static float[] fillArray(float[] arr){
        Arrays.fill(arr, 1);
        return arr;
    }

    public static float calcFormula(float value, int i){
        return (float)(value * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    public static long methodOne(float[] arr){
        long a;
        a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++){
            arr[i] = calcFormula(arr[i], i);
        }
        return (System.currentTimeMillis() - a);
    }

    public static long methodTwo(float[] arr){
        long a;
        float[] arr1 = new float[size/2];
        float[] arr2 = new float[size - size/2];

        a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        System.arraycopy(arr, arr1.length - 1, arr2, 0, arr2.length);

        new Thread(String.valueOf(methodOne(arr1))).start();
        new Thread(String.valueOf(methodOne(arr2))).start();

        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        System.arraycopy(arr2, 0, arr, arr1.length - 1, arr2.length);

        return (System.currentTimeMillis() - a);
    }
}
