package com.nmosipenko.study.sortingalgorithms.sorting;

import java.util.Collections;
import java.util.List;

/**
 * @author Osipenko-NM
 * mail NMOsipenko@mail.ru
 * @link https://github.com/NMOsipenko
 */

public class BubbleSort implements ISort<Integer> {

    @Override
    public List<Integer> sort(List<Integer> sortList) {

        boolean isSorted = true;

        for (int j = 0; j < sortList.size(); j++) {
            for(int i = 1; i < (sortList.size() - j); i++) {
                if(sortList.get(i) < sortList.get(i -1)) {
                    isSorted = false;
                    Collections.swap(sortList, i, (i - 1));
                }
            }

            if(isSorted)
                break;
        }

        return sortList;
    }
}
