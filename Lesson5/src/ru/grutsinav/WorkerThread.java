package ru.grutsinav;

import static ru.grutsinav.Main.calcFormula;

public class WorkerThread extends Thread{
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
