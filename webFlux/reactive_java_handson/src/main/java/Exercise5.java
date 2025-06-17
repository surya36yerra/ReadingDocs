package io.javabrains.reactiveworkshop;

import jdk.jshell.JShell;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here


        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here

        System.out.println("Press a key to end");
        System.in.read();
    }

    Class MySubscriber extend BaseSubscriber<T>
    {
        public void hookOnSubscribe(Subscription subscription){
        System.out.println("subscribe happened");
    }


        public void hookOnNext(T value){
        System.out.println(value.toString(),+"received");
    }


    }


}