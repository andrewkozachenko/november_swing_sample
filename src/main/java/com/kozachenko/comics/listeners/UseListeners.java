package com.kozachenko.comics.listeners;


import java.util.ArrayList;
import java.util.List;

interface AListener{
    void doEvent();
}

class A{
    List<AListener> listeners;

    public A() {
        listeners = new ArrayList<>();
    }

    public void addListener(AListener listener){
        listeners.add(listener);
    }

    public void doSomething(){
        //Делаем что-то о чем требуется оповестить всех слушателей
        System.out.println("Делаем что-то о чем требуется оповестить всех слушателей");
        for( int i = 0; i < listeners.toArray().length; i++ ) {
            ((AListener)listeners.toArray()[i]).doEvent(); //class A не знает кто его слушает
        }
    }
}

class B implements AListener {
    public void doEvent(){
        System.out.println("Do event");
    }
}



public class UseListeners {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        B c = new B();

        a.addListener(b);
        a.addListener(c);

        a.doSomething();
    }

}
