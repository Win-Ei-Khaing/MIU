package edu.mum.cs544.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AClass extends MySuper{
    private BClass bClass;

    @Autowired 
    public  AClass(BClass b){
        System.out.println("myclass constructor");
        setText("Hello");
        this.bClass=b;
    }

    public void getAText(){
        System.out.println("this is a "+ getText());
    }

    public void getBText(){
        System.out.println("this is a "+ bClass.getText());
}
}