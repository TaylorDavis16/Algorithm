package com.taylor.Queue.test;


import com.taylor.Queue.queue.Queue;
import com.taylor.Queue.queue.QueueFullException;

import java.util.Scanner;

public class Method {
    public static void act(Queue queue){
        System.out.println("Press 1 to Add\nPress 2 to Get\nPress 3 to show\nPress 4 to peek\nPress 5 to Count");
        Scanner scanner=new Scanner(System.in);
        char c=scanner.next().charAt(0);
        switch (c){
            case '1':
                System.out.println("Enter a element!");
                int value=scanner.nextInt();
                try {
                    queue.add(value);
                }catch (QueueFullException e){
                    System.out.println(e.getMessage());
                    System.out.println("-------------------------------------");
                }
                break;
            case '2':
                try{
                    System.out.println("The value is "+queue.get());
                    System.out.println("-------------------------------------");
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    System.out.println("-------------------------------------");
                }
                break;
            case '3':
                queue.show();
                System.out.println("-------------------------------------");
                break;
            case '4':
                try{
                    System.out.println("The first element is "+queue.peek());
                    System.out.println("-------------------------------------");
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    System.out.println("-------------------------------------");
                }
                break;
            case '5':
                System.out.println("The number of element is "+queue.count());
                System.out.println("-------------------------------------");
                break;
            default:
                System.out.println("Invalid input!");
                System.exit(1);

        }
    }
}
