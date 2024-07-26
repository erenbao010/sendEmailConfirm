package com.example.CTGTDL;

import com.example.CTGTDL.array.Dog;
import com.example.CTGTDL.array.DynamicArr;
import com.example.CTGTDL.dependencyInjection.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CtgtdlApplication {

	public static void main(String[] args) {
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
	}

}
