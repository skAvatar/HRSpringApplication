package com.hr.hrspring.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 Check-> Exceptions that are check during compile time
 IOException / Interrupted Exception / Remote Exception

 Uncheck-> Exceptions that happens in Runtime:
 something that has gone wrong with the program and is unrecoverable
 RuntimeExceptions / NullPointerException / Index Out od Bounds

 Partially Checked -> is a checked exception where some of its child classes are unchecked
 Error / LinkageError / AssertionError

 */
public class TypesOfExceptionsTest {

    @Test
    void showHierarchy(){

        try {
            DisplayImage img= new DisplayImage();
            Thread.sleep(Long.MAX_VALUE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void checkFileExceptions(){

        try {
            FileReader reader = new FileReader("src/main/resources/files/TestRead.txt");
            System.out.println(reader.read());

            Assertions.assertNotNull(reader);
        } catch (FileNotFoundException e) { // NullPointerException | IOException ioe
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    void unCheckNullExceptions(){

        String nullString = null;
        try {
            System.out.println(nullString.length());
        } catch (NullPointerException e) {
            Assertions.assertNotNull(e);
            System.out.println("null > " + e);
        }

    }

    @Test
    void finallyTest(){
        String textFinally = "finally";
        System.out.println("return Finally Block ---------------");
        System.out.println(returnFinally("10"));
        System.out.println("call Finally Block ---------------");
        callFinally(textFinally);

    }

    private String returnFinally(String textFinally) {
        int textInt = 0;
        try{
            textInt = Integer.parseInt(textFinally);
            return "Code In Try ";
        }catch(Exception e){
            textFinally = "Code In Cacth " + textInt;
            return textFinally;
        }finally {
            textInt = Integer.parseInt("4");
            return textFinally + "\nFinallyBlock " + textInt;
        }
    }

    private void callFinally(String textFinally) {

        try{
            System.out.println(textFinally);
        }catch(Exception e){
            System.out.println(textFinally + " Catch");
        }finally {
            System.out.println(textFinally + " Finally Block");
        }
    }

    public class DisplayImage {

        public DisplayImage() throws IOException
        {
            BufferedImage img=ImageIO.read(new File("src/main/resources/files/exceptions.png"));
            ImageIcon icon=new ImageIcon(img);
            JFrame frame=new JFrame();
            frame.setLayout(new FlowLayout());
            frame.setSize(2000,1500);
            JLabel lbl=new JLabel();
            lbl.setIcon(icon);
            frame.add(lbl);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }



}
