package com.example.CTGTDL;

import com.example.CTGTDL.array.DynamicArr;
import com.example.CTGTDL.dependencyInjection.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CtgtdlApplication {
    public static void main(String[] args) throws IOException {

        DynamicArr<String> dynamicArr = new DynamicArr<>();
        dynamicArr.add("1");
        dynamicArr.add("2");
        dynamicArr.add("3");
        dynamicArr.add("4");
        dynamicArr.add("5");
        System.out.println(dynamicArr.toString());
        ApplicationContext context = SpringApplication.run(CtgtdlApplication.class, args);
        Engine engine = context.getBean(Engine.class);
        System.out.println(engine);

        String[] src = {"src/main/resources/zipTest/zipTest2.txt", "src/main/resources/zipTest/zipTest1.txt"};
        ZipFiles.ZipMultipleFiles(src, "Zipfileaaa.zip");
    }
}

