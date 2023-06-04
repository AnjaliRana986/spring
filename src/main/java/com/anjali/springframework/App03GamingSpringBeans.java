package com.anjali.springframework;

import com.anjali.springframework.game.GameRunner;
import com.anjali.springframework.game.GamingConsole;
import com.anjali.springframework.game.PacmanGame;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// this is a configuration file containing spring beans
 class GamingConfiguration {
    //    var game = new MarioGame();
    //        var game = new SuperContraGame();

    @Bean
    public GamingConsole game(){
        var game = new PacmanGame();  //1. Object creation
        return game;
    }
    @Bean
    public  GameRunner gameRunner(GamingConsole game){
        var gameRunner = new GameRunner(game); //1. Object creation
        //1 method : pas game as method. list down below
//        var gameRunner = new GameRunner(game());
        //2nd method: pass in teh parameter.  using 2nd method rn
        return gameRunner;
    }


}

public class App03GamingSpringBeans {
    public  static void main(String[] args){
        try( var context =
                     new AnnotationConfigApplicationContext
                             (GamingConfiguration.class)){
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
