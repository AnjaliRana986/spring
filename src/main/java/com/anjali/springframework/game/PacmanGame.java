package com.anjali.springframework.game;

import org.springframework.stereotype.Component;

@Component
public class PacmanGame implements GamingConsole {
    public  void up(){
        System.out.println("UP");
    }
    public  void down(){
        System.out.println("DOWN");
    }
    public  void left(){
        System.out.println("left");
    }
    public  void right(){
        System.out.println("Right");
    }
}
