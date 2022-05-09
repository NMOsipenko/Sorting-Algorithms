package com.nmosipenko.study.sortingalgorithms.sorting;

import java.util.Collections;
import java.util.List;

/**
 * @author Osipenko-NM
 * mail NMOsipenko@mail.ru
 * @link https://github.com/NMOsipenko
 */

public class InsertionSort implements ISort<Integer>{

    @Override
    public List<Integer> sort(List<Integer> sortList) {

        for(int j = 1; j < sortList.size(); j++) {
            for(int i = j; i > 0; i--) {
                if(sortList.get(i) < sortList.get(i - 1))
                    Collections.swap(sortList, i, (i - 1));
            }
        }

        return sortList;
    }

}
