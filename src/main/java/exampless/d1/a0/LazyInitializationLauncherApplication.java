package exampless.d1.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
class ClassA {   // class   A for which we are creating a bean

}

// ans classs B using classA bean to initialize itself
@Component
@Lazy  //classB bean not initialized at startup
class ClassB {
    private ClassA classA;
    public ClassB(ClassA classA) {
        System.out.println("Some Initialization Logic");
        //Logic
        this.classA = classA;
    }
    public  void dosomething() {
        System.out.println("Do something");
    }

}
// this is a configuration file containing spring beans
@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {


    public  static void main(String[] args){
        try (var context =
                     new AnnotationConfigApplicationContext
                             (LazyInitializationLauncherApplication.class)){
            System.out.println("Intialization of context is completed");
            context.getBean(ClassB.class).dosomething();

        }

    }
}
