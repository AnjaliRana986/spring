package exa.f1.a0;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All dependency are ready !");
    }
    @PostConstruct
    public  void initialize(){
        someDependency.getReady();
    }

    // close your active connections
    @PreDestroy
    public  void cleanup(){
        System.out.println("CleanUp");
    }
}

@Component

class SomeDependency {

    public void getReady() {
        System.out.println("Some logic using someDependency");
    }
}
@Configuration
@ComponentScan
public class PrePostContextLauncherApplication {


    public  static void main(String[] args){
        try (var context =
                     new AnnotationConfigApplicationContext
                             (PrePostContextLauncherApplication.class)){

        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        }

    }
}
