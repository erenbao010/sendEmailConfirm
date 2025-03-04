package com.example.CTGTDL.dependencyInjection;

public class veryComplexService {
    private SortAlg sortAlg;

    public veryComplexService(SortAlg sortAlg) {
        this.sortAlg = sortAlg;
    }

    public void complexBusiness(int array[]) {
            sortAlg.sort(array);
    }
}


