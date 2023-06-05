package example.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


// this is a configuration file containing spring beans
@Configuration
@ComponentScan
public class SimpleSpringContextLauncherApplication {


    public  static void main(String[] args){
        try (var context =
                     new AnnotationConfigApplicationContext
                             (SimpleSpringContextLauncherApplication.class)){

        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        }

    }
}
