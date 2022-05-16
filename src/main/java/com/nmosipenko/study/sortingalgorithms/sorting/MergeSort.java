package com.nmosipenko.study.sortingalgorithms.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Osipenko-NM
 * mail NMOsipenko@mail.ru
 * @link https://github.com/NMOsipenko
 */

public class MergeSort implements ISort<Integer>{

    @Override
    public List<Integer> sort(List<Integer> sortList) {

        if(sortList.size() <= 1)
            return sortList;

        int average = sortList.size() / 2;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();


        for(int i = 0; i < average; i++) {
            left.add(sortList.get(i));
        }

        for(int i = average; i < sortList.size(); i++) {
            right.add(sortList.get(i));
        }

        List<Integer> leftSort = sort(left);
        List<Integer> rightSort = sort(right);

        sortList = mergeSort(leftSort, rightSort);

        return sortList;
    }

    private List<Integer> mergeSort (List<Integer> left, List<Integer> right) {

        int leftIndex = 0;
        int rightIndex = 0;
        List<Integer> res = new ArrayList<>();

        System.out.print("in left - " + left + " in right - " + right + " === ");

        while(leftIndex < left.size() && rightIndex < right.size()) {
            if(left.get(leftIndex) <= right.get(rightIndex)) {
                res.add(left.get((leftIndex)++));
            } else {
                res.add(right.get((rightIndex)++));
            }

        }

        while (leftIndex < left.size()) {
            res.add(left.get((leftIndex)++));
        }

        while (rightIndex < right.size()) {
            res.add(right.get((rightIndex)++));
        }

        System.out.println(res);
        return res;

    }

}
