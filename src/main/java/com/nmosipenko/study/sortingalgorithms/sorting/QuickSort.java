package com.nmosipenko.study.sortingalgorithms.sorting;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Osipenko-NM
 * mail NMOsipenko@mail.ru
 * @link https://github.com/NMOsipenko
 */

public class QuickSort implements ISort {

    @Override
    public List sort(List sortList) {
        return quickSort(sortList, 0, sortList.size());
    }

    public List quickSort(List sortList, int i, int j) {
        if(i == j)
            return sortList;
        int pivot = partition(sortList, i, j);
        quickSort(sortList, i, pivot);
        quickSort(sortList, pivot + 1, j);

        return sortList;
    }

    private int partition(List<Integer> sortList, int i, int j) {
        int pivot = (int)(((Math.random() * (j - i)) + i));
        Collections.swap(sortList, i, pivot);
        pivot = i;
        int s1_index = i;

        for(int k = i + 1; k < j; k++) {
            if(sortList.get(k) < sortList.get(pivot)) {
                ++s1_index;
                Collections.swap(sortList, s1_index, k);
            }
        }

        Collections.swap(sortList, pivot, s1_index);
        pivot = s1_index;

        return pivot;
    }


}
