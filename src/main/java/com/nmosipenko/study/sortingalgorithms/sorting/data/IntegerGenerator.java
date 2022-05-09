package com.nmosipenko.study.sortingalgorithms.sorting.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Osipenko-NM
 * mail NMOsipenko@mail.ru
 * @link https://github.com/NMOsipenko
 */

public class IntegerGenerator{

    public static List<Integer> getEntityList(int size, int max) {

        List<Integer> targetList = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            targetList.add(rnd(max));
        }
        return targetList;
    }

    public static Integer rnd(int max)
    {
        return (int) (Math.random() * ++max);
    }
}
