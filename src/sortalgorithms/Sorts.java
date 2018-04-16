package sortalgorithms;

import java.io.*;
import java.util.Random;

public class Sorts {
    
    public void bubbleSort(int[] unsorted) {
        boolean swap;
        int temp;
        
        do {
            swap = false;
            for (int i = 0; i < (unsorted.length - 1); i++)
                if (unsorted[i] > unsorted[i + 1]) {
                    temp = unsorted[i];
                    unsorted[i] = unsorted[i + 1];
                    unsorted[i + 1] = temp;
                    swap = true;
                }
        } while (swap);
    }
    
    public void insertionSort(int[] unsorted) {
        int temp, indexHole;
        
        for (int i = 1; i < unsorted.length; i++) {
            temp = unsorted[i];
            indexHole = i;
            
            while (indexHole > 0 && unsorted[indexHole - 1] > temp) {
                unsorted[indexHole] = unsorted[indexHole - 1];
                indexHole--;
            }
            unsorted[indexHole] = temp;
        }
    }
    
    public int[] mergeSort(int[] unsorted) {
        int size;
        if (unsorted.length > 1) {
            size = unsorted.length / 2;
            int[] left_array = new int[size];
            int[] right_array = new int[unsorted.length - size];
            
            for (int i = 0; i < size; i++)
                left_array[i] = unsorted[i];
            
            for (int i = size; i < unsorted.length; i++)
                right_array[i - size] = unsorted[i];
            
            return merge(mergeSort(left_array), mergeSort(right_array));
        }
        
        return unsorted;
    }
    
    public int[] merge(int[] a, int[] b) {
        int lenght = a.length + b.length;
        int[] c = new int[lenght];
        int index_a = 0, index_b = 0, index_c = 0;
        
        while (index_a < a.length && index_b < b.length) {
            if (a[index_a] < b[index_b]) {
                c[index_c] = a[index_a];
                index_a++;
            } else {
                c[index_c] = b[index_b];
                index_b++;
            }
            index_c++;
        }
        
        while (index_a < a.length) {
            c[index_c] = a[index_a];
            index_a++;
            index_c++;
        }
        
        while (index_b < b.length) {
            c[index_c] = b[index_b];
            index_b++;
            index_c++;
        }
        
        return c;
    }
    
    public void countingSort(int[] unsorted) {
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < unsorted.length; i++)
            if (unsorted[i] > max)
                max = unsorted[i];
        
        int[] aux = new int[max + 1];
        
        for (int i = 0; i < unsorted.length; i++)
            aux[unsorted[i]]++;
        
        int indexS = 0;
        for (int i = 0; i < aux.length; i++)
            for (int j = 0; j < aux[i]; j++) {
                unsorted[indexS] = i;
                indexS++;
            }
        
        aux = null;
        System.gc();
    }
    
    public void quickSort(int[] unsorted) {
        if (true) {
            
        } else {
            int pivot = unsorted[0];
            int[] lessSubArray = new int[(int) (unsorted.length/2)];
            int[] greaterSubArray = new int[(int) (unsorted.length/2)];
            for (int i = 1; i < unsorted.length; i++) {
                if (unsorted[i] < pivot) {
                    
                }
            }
        }
    }
    
    public void printArray(int[] array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for (int i = 0; i < array.length; i++)
            bw.write(array[i] + " ");
        
        bw.write("\n");
        bw.flush();
    }
    
    public int[] bigArray(int lenght) {
        Random rd = new Random();
        int[] temp = new int[lenght];
        
        for (int i = 0; i < lenght; i++)
            temp[i] = rd.nextInt(100);
        
        return temp;
    }
    
    public static void main(String[] args) throws IOException {
        Sorts sorts = new Sorts();
        int[] a = sorts.bigArray(100000);
        int[] b = a.clone();
        int[] c = a.clone();
        int[] d = a.clone();
        sorts.printArray(a);
        long ta = System.currentTimeMillis();
        sorts.bubbleSort(a);
        System.out.println(System.currentTimeMillis()-ta);
        sorts.printArray(a);
        sorts.printArray(b);
        long tb = System.currentTimeMillis();
        sorts.insertionSort(b);
        System.out.println(System.currentTimeMillis()-tb);
        sorts.printArray(b);
        sorts.printArray(c);
        long tc = System.currentTimeMillis();
        c = sorts.mergeSort(c);
        System.out.println(System.currentTimeMillis()-tc);
        sorts.printArray(c);
        sorts.printArray(d);
        long td = System.currentTimeMillis();
        sorts.countingSort(d);
        System.out.println(System.currentTimeMillis()-td);
        sorts.printArray(d);
    }
    
}
