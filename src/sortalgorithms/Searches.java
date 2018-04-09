package sortalgorithms;

import java.io.IOException;

public class Searches {

    public int binarySearch(int[] array, int x) {
        int lowerBound = 0, upperBound = array.length - 1, index = -1, middlePoint;
        
        while (lowerBound < upperBound) {
            middlePoint = (upperBound + lowerBound) / 2;
            if (x == array[middlePoint]) {
                index = middlePoint;
                break;
            } else if (x < array[middlePoint])
                upperBound = middlePoint - 1;
            else
                lowerBound = middlePoint + 1;
        }
        
        if (lowerBound == upperBound && array[lowerBound] == x)
            index = lowerBound;
        
        return index;
    }
    
    public int binarySearchRecursive(int[] array, int x, int lB, int uB) {
        int middlePoint = (lB + uB) / 2;
        if (lB == uB)
            if (x == array[middlePoint])
                return middlePoint;
            else
                return -1;
        else
            if (x == array[middlePoint])
                return middlePoint;
            else
                if (x < array[middlePoint])
                    return binarySearchRecursive(array, x, lB, middlePoint - 1);
                else
                    return binarySearchRecursive(array, x, middlePoint + 1, uB);
    }
    
    public static void main(String[] args) throws IOException {
        Sorts sorts = new Sorts();
        Searches searches = new Searches();
        
        int[] a = sorts.bigArray(100);
        sorts.printArray(a);
        a = sorts.mergeSort(a);
        sorts.printArray(a);
        
        System.out.println(searches.binarySearchRecursive(a, 59, 0, a.length - 1));
    }
    
}
