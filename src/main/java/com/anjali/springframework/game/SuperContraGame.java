package com.anjali.springframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole {
    public  void up(){
        System.out.println("UP");
    }
    public  void down(){
        System.out.println("DOWN");
    }
    public  void left(){
        System.out.println("Go back");
    }
    public  void right(){
        System.out.println("Shot a bullet");
    }
}
