package exxam.h1.a0;

//import exampleee.g1.a0.BusinessService;
import com.anjali.springframework.game.GameRunner;
import exampleee.g1.a0.CdiContextContextLauncherApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


// this is a configuration file containing spring beans
//@Configuration
//@ComponentScan
public class XmlConfigurationContextLauncherApplication {


    public  static void main(String[] args){
        try (var context =
                     new ClassPathXmlApplicationContext
                             ("contextConfiguration.xml")){

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("game"));
            context.getBean(GameRunner.class).run();



        }

    }

}
