package edu.mum.cs544;

import org.springframework.stereotype.Component;

@Component
public class ClassC {
    private String text;

    public ClassC(){
        System.out.println("Class C constructor");
    }

    public void setString(String text){
        this.text=text;
        System.out.println("setting text in class c");
    }
}
