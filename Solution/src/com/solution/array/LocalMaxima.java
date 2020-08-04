package com.solution.array;

import com.solution.main.*;

import java.util.*;

public class LocalMaxima {
    public void run() {
        Scanner sc = ReadInput.getScanner("localMaxima");
        int size = sc.nextInt();

        String array = sc.next();

        int[] arr = ReadInput.getIntArray(size, array);

        doMaxima(arr, 0, arr.length - 1);

    }

    private void doMaxima(int[] arr, int beginIndex, int endIndex) {

        int e_index = (beginIndex + endIndex) / 2;

        if (e_index > 0 && e_index < arr.length - 1) {

            if (arr[e_index] >= arr[e_index - 1] && arr[e_index] >= arr[e_index + 1]) {
                System.out.println(arr[e_index]);
                return;
            } else if (arr[e_index] > arr[e_index - 1] && arr[e_index] < arr[e_index + 1]) {
                doMaxima(arr, e_index + 1, endIndex);
            } else {
                doMaxima(arr, beginIndex, e_index - 1);
            }
        }
        //Edge case
        if (e_index == 0) {
            doMaxima(arr, e_index + 1, endIndex);
        }


    }
}
