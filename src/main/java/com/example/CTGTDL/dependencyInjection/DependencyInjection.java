package com.example.CTGTDL.dependencyInjection;

public class DependencyInjection {
    public static void main(String[] args) {
        BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
        SortAlg bubbleSort = new BubbleSortAlgorithm();
        SortAlg quickShort = new quickShort();
        veryComplexService b1 = new veryComplexService(bubbleSort);
        veryComplexService b2 = new veryComplexService(quickShort);
        System.out.println(b1);
    }

}












