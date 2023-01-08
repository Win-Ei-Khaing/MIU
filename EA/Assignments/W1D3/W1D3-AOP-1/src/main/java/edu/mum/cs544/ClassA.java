package edu.mum.cs544;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ClassA {
    private String text;
    @Autowired
    private ClassB classB;

    public ClassA(@Value("Hello") String text){
        this.text=text;
        System.out.println("Class A constructor - text : "+text);
    }

    public void setText(String text){
        System.out.println("setting text in class A");
        this.text=text;
    }

    public void setClassB(ClassB classB){
        System.out.println("setting class B");
        this.classB = classB;
    }

    public void showText(){
        System.out.println("Class A text : "+text);
        classB.showText();    
    }

    @PostConstruct
    public void init(){
        System.out.println("Class A init - text: "+text);
    }

    @PreDestroy
    public void destory(){
        System.out.println("Class A destroy");
    }
}
