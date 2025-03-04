package com.example.CTGTDL.array;

import com.example.CTGTDL.CtgtdlApplication;
import org.springframework.boot.SpringApplication;
import java.util.Scanner;
public class ArrMain {
    public static void main(String[] args) {

        DynamicArr<String> dynamicArr = new DynamicArr<>();
        dynamicArr.add("b");
        dynamicArr.add("a");
        dynamicArr.add("t");
        dynamicArr.add("t");
        dynamicArr.add("e");
        System.out.println(dynamicArr.toString());
        Scanner reader = new Scanner(System.in);

        // Examples of reading different types of user input
//        String text = reader.nextLine();
//        int number = Integer.valueOf(reader.nextLine());
//        double numberWithDecimals = Double.valueOf(reader.nextLine());
//        boolean trueOrFalse = Boolean.valueOf(reader.nextLine());


//        int breakPoint = 0;
//        while (true) {
//
//            Scanner scanner = new Scanner(System.in);
//            String sum =  scanner.nextLine();
//            breakPoint++;
//            if (sum.equals("no")) {
//                System.out.println(sum);
//                break;
//            } else {
//                System.out.println(sum);
//            }
//
//        }
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Shall we carry on");
//        int sum = Integer.valueOf(scanner.nextLine());
//        while(true) {
//            if(sum !=0) {
//                System.out.println(sum);
//                break;
//            }
//        }
//        scanner.close();
//
//        Scanner scanner = new Scanner(System.in);
//        int start = 1;
//        int input = Integer.valueOf(scanner.nextLine());
//        System.out.println("Where to?" + input);
//        while (input >=start) {
//            System.out.println(start);
//            start++;
//        }
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Where to?" );
        int input1 = Integer.valueOf(scanner2.nextLine());
        System.out.print("Where from?" );
        int input2 = Integer.valueOf(scanner2.nextLine());
        while (input1 >=input2) {
            System.out.println(input2);
            input2++;
        }
    }
}
