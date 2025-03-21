package jinjiriin;

import java.io.File;
import java.io.IOException;


public class Jinjiriin {
    public static void main(String[] args) {
        notepad notepad = new notepad();
        notepad.setVisible(true);


        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
               System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
       
 }
    
