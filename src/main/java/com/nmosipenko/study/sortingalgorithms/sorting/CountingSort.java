package com.nmosipenko.study.sortingalgorithms.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Osipenko-NM
 * mail NMOsipenko@mail.ru
 * @link https://github.com/NMOsipenko
 */

public class CountingSort implements ISort<Integer> {

    @Override
    public List<Integer> sort(List<Integer> sortList) {

        int minimum = sortList.get(0);
        int maximum = sortList.get(0);

        for (int i = 0; i < sortList.size(); i++) {

            if (minimum > sortList.get(i)) {
                minimum = sortList.get(i);
            }

            if (maximum < sortList.get(i)) {
                maximum = sortList.get(i);
            }

        }

        int[] countingArr= new int[(maximum - minimum + 1)];

        for (int i = 0; i < sortList.size(); i++) {
            Integer count = (sortList.get(i) - minimum);
            System.out.println(count);
            countingArr[count] = countingArr[count] + 1;
        }

        sortList.clear();

        for (int i = 0; i < countingArr.length; i++) {
            int count = countingArr[i];
            for (int j = 0; j < count; j++) {
                sortList.add(i + minimum);
            }
        }


        return sortList;
    }
}
