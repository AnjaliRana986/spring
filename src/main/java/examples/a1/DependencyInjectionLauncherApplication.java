package examples.a1;

import  java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


//Using Field Injection
//added autowired : spring will automatically do Field Injection
@Component
class YourBusinessClass{
    @Autowired
    Dependency1 dependency1;

    @Autowired
    Dependency2 dependency2;

    public  String toString(){
        return "Using " + dependency1 + " and " + dependency2;
    }
}
@Component
class Dependency1{

}
@Component
class Dependency2{

}

// use 3 types of injection to inject dependency 1 and 2 into your business class
// this is a configuration file containing spring beans


@Configuration
@ComponentScan
public class DependencyInjectionLauncherApplication {


    public  static void main(String[] args){
        try (var context =
                     new AnnotationConfigApplicationContext
                             (DependencyInjectionLauncherApplication.class)){

        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
            System.out.println(context.getBean(YourBusinessClass.class));
        }

    }
}
