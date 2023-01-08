package edu.mum.cs544;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ClassB {
    @Value("World")
    private String text;

    public ClassB(){
        System.out.println("Class B constructor - text : "+text);
    }

    public void setText(String text){
        System.out.println("setting text in class B");
        this.text=text;
    }

    public void showText(){
        System.out.println("Class B text: "+text);
    }

    @PostConstruct
    public void intit(){
        System.out.println("Class B init - text : "+text);
    }

    @PreDestroy
    public void destory(){
        System.out.println("Class B destory");
    }
}
