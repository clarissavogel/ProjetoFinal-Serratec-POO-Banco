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
    
    //Construtor com finalidade de puxar o path absoluto da raiz do programa
    public Comprovante() {
        this.pathDiretorio = System.getProperty("user.dir");
        System.out.println(this.pathDiretorio);
    }


    //Escreve qualquer objeto Serializable no caminho designado
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


    //Lê qualquer objeto Serializable no caminho designado
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


    //Escreve qualquer String no caminho designado
    public void printarComprovante(String string, String filepath) throws FileNotFoundException {
        String absolutePath = this.pathDiretorio + "\\" + filepath + ".txt";
        try (PrintWriter out = new PrintWriter(absolutePath)) {
            out.println(string);
            out.close();
        }

    }


}
