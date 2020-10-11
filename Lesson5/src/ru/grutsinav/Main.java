package ru.grutsinav;

import java.util.Arrays;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args){
        System.out.println("Время выполения метода без потоков: " + methodOne(fillArray(initArray(size)))
                + " мc");

        System.out.println("Время выполения метода с потоками: " + methodTwo(fillArray(initArray(size)))
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
        return (float)(value * Math.sin(0.2f + (float)i / 5) * Math.cos(0.2f + (float)i / 5) *
                Math.cos(0.4f + (float)i / 2));
    }



    public static long methodOne(float[] arr){
        long a;

        a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++){
            arr[i] = calcFormula(arr[i], i);
        }

        return (System.currentTimeMillis() - a);
    }


    public static long methodTwo(float[] arr) {
        long a;
        float[] arr1 = new float[size/2];
        float[] arr2 = new float[size - size/2];

        a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        System.arraycopy(arr, arr1.length, arr2, 0, arr2.length);

        WorkerThread worker1 = new WorkerThread(arr1, 0, "1");
        WorkerThread worker2 = new WorkerThread(arr2, arr1.length, "2");

        try{
            worker1.join();
            arr1 = worker1.arr;
            worker2.join();
            arr2 = worker2.arr;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        System.arraycopy(arr2, 0, arr, arr1.length, arr2.length);

        return (System.currentTimeMillis() - a);
    }

    static class WorkerThread extends Thread {
        float[] arr;
        long a;
        int index;

        WorkerThread(float[] arr, int index, String name) {
            super(name);
            this.arr = arr;
            this.index = index;
            start();
        }

        @Override
        public void run() {
            a = System.currentTimeMillis();
            for (int i = 0; i < arr.length; i++){
                arr[i] = calcFormula(arr[i], index++);
            }
            System.out.printf("Время исполнения потока %s: %s мс \n", this.getName(), System.currentTimeMillis() - a);
        }
    }
}
