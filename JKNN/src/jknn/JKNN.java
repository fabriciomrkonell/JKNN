package jknn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class JKNN {

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        LinkedList latt = new LinkedList();
        LinkedList lclass = new LinkedList();
        
        //Ler o arquivo.csv
        String csvFile = "C:\\Users\\fabricio.konell\\Desktop\\JKNN\\dados\\wdbc.data";
        BufferedReader br = null;
        String line = "";
                
                
         br = new BufferedReader(new FileReader(csvFile));
         while ((line = br.readLine()) != null){
             String[] insStr = line
                     
                     
                     Distância 
                             
                             d = Rais QUadrada [ Somatorio * (xi = xj)²]
                     
         }                
        
        for(int i = 0; i < latt.size(); i++){                        
            System.out.println(Arrays.toString((float[]) latt.get(i)) + " - classe: " + (String)lclass.get(i));
        }
    }
    
}
