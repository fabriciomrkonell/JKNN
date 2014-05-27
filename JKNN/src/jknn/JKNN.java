package jknn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class JKNN {

    static int[][] classificador = {{0, 0, 0, 0}, {0, 0, 0, 0}};

    public static void main(String[] args) throws FileNotFoundException, IOException {

        LinkedList latt = new LinkedList();
        LinkedList lclass = new LinkedList();
        LinkedList resultados = new LinkedList();

        /*
         classificador[0][0] = 1;
         int[0][1] = 1;
         int[1][0] = 1;
         int[1][1] = 0;               
         */
        String csvFile = "C:\\Fabricio\\JKNN\\dados\\wdbc.data";
        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";
        int ultimos = 0;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] insStr = line.split(cvsSplitBy);

                float[] atts = new float[insStr.length - 2];

                for (int i = 0; i < insStr.length - 2; i++) {
                    atts[i] = Float.valueOf(insStr[i + 2]).floatValue();
                }

                latt.add(atts);
                lclass.add(insStr[1]);

            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }

        ultimos = latt.size() - ((latt.size() / 3) * 2);

        for (int j = latt.size() - ultimos; j < latt.size(); j++) {

            float menor = 10000000;
            int posicao = 0;

            float[] f = (float[]) latt.get(j);

            for (int i = 0; i < latt.size() - ultimos; i++) {
                float[] f1 = (float[]) latt.get(i);
                resultados.add(distanciaEuclides(f, f1));
            }

            for (int w = 0; w < resultados.size(); w++) {
                if ((float) resultados.get(w) < menor) {
                    posicao = w;
                    menor = (float) resultados.get(w);
                }
            }

            System.out.format("%s \t\t %s \n", Arrays.toString(f) + (String) lclass.get(j), (String) lclass.get(posicao));
            Object var1 = lclass.get(j);
            Object var2 = lclass.get(posicao);
            classificadorConfuso(var1.toString(), var2.toString());
            resultados.retainAll(latt);
        }
        print(classificador);       
    }

    public static float distanciaEuclides(float[] v1, float[] v2) {
        float soma = 0;
        for (int i = 0; i < v1.length; i++) {
            soma = soma + (float) Math.pow(v1[i] - v2[i], 2);
        }
        return (float) Math.sqrt(soma);
    }

    public static void classificadorConfuso(String confuso, String original) {
        if ("M".equals(confuso)) {
            if ("M".equals(original)) {
                classificador[0][0] = classificador[0][0] + 1;
            } else {
                classificador[1][0] = classificador[1][0] + 1;
            }
        } else {
            if ("M".equals(original)) {
                classificador[0][1] = classificador[0][1] + 1;
            } else {
                classificador[1][1] = classificador[1][1] + 1;
            }
        }
    }
    
    public static void print(int[][] vish){        
        System.out.println("M   B");
        System.out.println(vish[0][0] + " " + vish[0][1] + " M");
        System.out.println(vish[1][0] + " " + vish[1][1] + " B");
    }
}
