package com.example.CTGTDL.dependencyInjection;

import java.time.*;

public class DependencyInjection {
    public static void main(String[] args) {
        BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
        SortAlg bubbleSort = new BubbleSortAlgorithm();
        SortAlg quickShort = new quickShort();
        veryComplexService b1 = new veryComplexService(bubbleSort);
        veryComplexService b2 = new veryComplexService(quickShort);
        System.out.println(b1);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalTime time = LocalTime.of(22,10);
        LocalTime localDateTime1 = LocalDateTime.of(LocalDate.now(), time)
                .atZone(ZoneId.of("America/Sao_Paulo"))
                .withZoneSameInstant(ZoneOffset.UTC)
                .toLocalTime();
    }

}












