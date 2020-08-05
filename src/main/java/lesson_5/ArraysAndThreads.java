package lesson_5;

public class ArraysAndThreads {

    static final int SIZE = 10000000;
    static final int H = SIZE / 2;
    long totalTime = 0;
    float[] arr = new float[SIZE];
    float[] a1 = new float[H];
    float[] a2 = new float[H];

    public void initArray(){
        for (int i = 0; i < SIZE; i++){
            arr[i] = 1;
        }
    }

    public synchronized void calculate(int size, int beginIndex){
        long startTimer = System.currentTimeMillis();
        int j = 0;
        j += beginIndex;
        for (int i = 0; i < size; i++){
            float alfa = 0.2f + (j / 5);
            float beta = 0.4f + (j / 2);
            float a = (float) (Math.sin(alfa));
            float b = (float) (Math.cos(alfa));
            float c = (float) (Math.cos(beta));
            arr[i] = (float) (arr[i]* a * b * c);
            j++;
        }
        long endTimer = System.currentTimeMillis();
        System.out.println("Поток :" + Thread.currentThread().getName() + ". Время обработки массива: " + (endTimer - startTimer));
    }

    public void calculateArrayMethodOne(){
        calculate(SIZE, 0);
    }

    public void calculateArrayMethodTwo() {
        ArraysAndThreads arrayThread1 = new ArraysAndThreads();
        ArraysAndThreads arrayThread2 = new ArraysAndThreads();
        arrayThread1.initArray();
        arrayThread2.initArray();
        new Thread(() -> arrayThread1.calculateArrayOne()).start();
        new Thread(() -> arrayThread2.calculateArrayTwo()).start();
        mergeArray();
    }

    public void calculateArrayOne(){
        System.arraycopy(arr, 0, a1, 0, H);
        calculate(H, 0);
    }

    public void calculateArrayTwo(){
        System.arraycopy(arr, H, a2, 0, H);
        calculate(H, H);
    }

    public void mergeArray(){
        long startTimer = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, H);
        System.arraycopy(a2, 0, arr, H, H);
        long endTimer = System.currentTimeMillis();
        System.out.println("Время склеивания массива: " + (endTimer - startTimer));
    }

    public static void main(String[] args) {
        ArraysAndThreads array = new ArraysAndThreads();
        array.initArray();
        array.calculateArrayMethodOne();
        array.calculateArrayMethodTwo();
    }


}
