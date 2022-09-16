package menu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Comprovante {

    public String pathDiretorio;
    

    public Comprovante() {
        this.pathDiretorio = System.getProperty("user.dir");
        System.out.println(this.pathDiretorio);
    }



    public void escreverObjetos(Object object, String filepath) {
        String absolutePath = this.pathDiretorio + filepath;
        try {
 
            FileOutputStream fileOut = new FileOutputStream(absolutePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(object);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }



    public Object lerObjetos(String filepath) {
        String absolutePath = this.pathDiretorio + filepath;
        try {
 
            FileInputStream fileIn = new FileInputStream(absolutePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            Object obj = objectIn.readObject();
 
            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;
 
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }


    }



    public void printarComprovante(String string, String filepath) throws FileNotFoundException {

        try (PrintWriter out = new PrintWriter(filepath)) {
            out.println(string);
            out.close();
        }
        
    }


}
