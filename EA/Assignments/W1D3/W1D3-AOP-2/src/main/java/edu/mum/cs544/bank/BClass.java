package edu.mum.cs544.bank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BClass{
    @Value("Other")
    private String text;

    public BClass() {
        System.out.println("blcass constructo ");
    }

    public String getText() {
        return text;
    }

    // @PreDestroy
    // public void done(){
    //     System.out.println("bclass done");
    // }
}
