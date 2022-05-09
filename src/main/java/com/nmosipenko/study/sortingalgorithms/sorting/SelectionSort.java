package com.nmosipenko.study.sortingalgorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Osipenko-NM
 * mail NMOsipenko@mail.ru
 * @link https://github.com/NMOsipenko
 */

public class SelectionSort implements ISort<Integer>{

    public List<Integer> sort (List<Integer> arr) {

        for(int j = 0; j < arr.size(); j++) {
            int minIndex = j;
            for(int i = j + 1; i < arr.size(); i++) {
                if(arr.get(i) < arr.get(minIndex))
                    minIndex = i;
            }

            Collections.swap(arr, j, minIndex);

        }

        return arr;
    }
}
