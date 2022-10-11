package com.currencyDenomination;

public class MergeSort {
    void merge(int arr[], int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;
        int lArray[] = new int[n1];
        int rArray[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            lArray[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            rArray[j] = arr[mid + 1 + j];
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (lArray[i] >= rArray[j]) {
                arr[k] = lArray[i];
                i++;
            } else {
                arr[k] = rArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = lArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rArray[j];
            j++;
            k++;
        }
    }
    public void mergesort(int[] notes, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergesort(notes, left, mid);
            mergesort(notes, mid + 1, right);
            merge(notes, left, mid, right);
        }
    }
}