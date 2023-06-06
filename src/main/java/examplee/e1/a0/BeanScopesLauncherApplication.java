package examplee.e1.a0;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;


// Create couple of beans ( class)
// creating two components -> one belonging to normal class and another one is belonging to prototype class
// difference between normal and prototype class

//Spring beans are defined to be used in a a specific scope:
// SINGLETON - One object instance per Spring IOC Container
//Prototype  -Possibly many object instances per Spring IOC Container. every time we asked for a bean from a Spring container it would create new instance

//Scopes applicable ONLY for Web-aware ApplicationContext
  // Request Scope - One Object instance per single HTTP request
  // Session Scope - One object instance per user HTTP session
  // Application Scope - One object instance per web application runtime
  // WebSocket Scope - One object instance per WebSocket instance
@Component
class NormalClass{

}
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass{

}

// this is a configuration file containing spring beans
@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {


    public  static void main(String[] args){
        try (var context =
                     new AnnotationConfigApplicationContext
                             (BeanScopesLauncherApplication.class)){
            // The hashcode for both will be the same ( getting same instance)
            // same instance would be returned each time when we asked for a bean from a spring context
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            // we are getting new hashcode each time (getting new instance of specific bean each time we call the prototype class)
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));


        }

    }
}

//Note : Java Singleton(GOF) vsSpring Singleton
  // Spring Singleton : One object instance per Spring IOC Container
  // Java Singleton : One object instance per JVM
