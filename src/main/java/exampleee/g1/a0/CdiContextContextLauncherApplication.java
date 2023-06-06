package exampleee.g1.a0;

import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//import jakarta.inject.Named;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;

@Component

//@Named
class  BusinessService{
    private DataService dataService;

    @Autowired
//    @Inject
    public void setDataService(DataService dataService) {
        System.out.println("Setter Injection");
        this.dataService = dataService;
    }
    public DataService getDataService() {

        return dataService;
    }


}
@Component
//@Named
class DataService{

}
// this is a configuration file containing spring beans
@Configuration
@ComponentScan
public class CdiContextContextLauncherApplication {


    public  static void main(String[] args){
        try (var context =
                     new AnnotationConfigApplicationContext
                             (CdiContextContextLauncherApplication.class)){

        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

        System.out.println(context.getBean(BusinessService.class).getDataService());
        }

    }
}
