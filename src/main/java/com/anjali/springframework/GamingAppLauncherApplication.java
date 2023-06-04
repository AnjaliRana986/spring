package com.anjali.springframework;

import com.anjali.springframework.game.GameRunner;
import com.anjali.springframework.game.GamingConsole;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// this is a configuration file containing spring beans
@Configuration
@ComponentScan("com.anjali.springframework.game")
public class GamingAppLauncherApplication {


    public  static void main(String[] args){
        try( var context =
                     new AnnotationConfigApplicationContext
                             (GamingAppLauncherApplication.class)){
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
