package edu.mum.cs544.bank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public abstract class MySuper {
    @Value("Test")
    private String text;

    public MySuper(){
        System.out.println("My super construuctor " + text);

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        System.out.println("setting text to "+text);
        this.text = text;
    }


}
