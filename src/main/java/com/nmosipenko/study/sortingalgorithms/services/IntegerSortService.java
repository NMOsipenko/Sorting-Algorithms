package com.nmosipenko.study.sortingalgorithms.services;

import com.nmosipenko.study.sortingalgorithms.Controller;
import com.nmosipenko.study.sortingalgorithms.sorting.ISort;
import com.nmosipenko.study.sortingalgorithms.sorting.data.IntegerGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Osipenko-NM
 * mail NMOsipenko@mail.ru
 * @link https://github.com/NMOsipenko
 */

public class IntegerSortService implements ISortingService<Integer>{

    private int size = 10;
    private int max = 100;
    private ISort<Integer> sortingService;
    private static final Logger LOGGER = LoggerFactory.getLogger(IntegerSortService.class);


    public IntegerSortService(ISort<Integer> sortService) {
        this.sortingService = sortService;
    }

    public IntegerSortService(ISort<Integer> sortService, int size) {
        this.sortingService = sortService;

        if(size > 0)
            this.size = size;

    }

    public IntegerSortService(ISort<Integer> sortService, int size, int max) {
        this.sortingService = sortService;

        if(size > 0)
            this.size = size;

        if(max > 0)
            this.max = max;
    }

    @Override
    public List<Integer> sort() {
        List<Integer> sortList = IntegerGenerator.getEntityList(this.size, this.max);

        if (sortList.size() < 1000)
            LOGGER.info("Origin list is :" + sortList);

        return this.sortingService.sort(sortList);
    }
}
