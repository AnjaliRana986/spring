package exam.c1.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


// this is a configuration file containing spring beans
@Configuration
@ComponentScan
public class RealWorldSpringContextLauncherApplication {


    public  static void main(String[] args){
        try (var context =
                     new AnnotationConfigApplicationContext
                             (RealWorldSpringContextLauncherApplication.class)){

        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println(context.getBean(BusinessCalculationService.class).findMax());
        }

    }
}
