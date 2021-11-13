package Clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Traductor {

    private String traducccion = "";
    private Diccionario diccionario;

    public void leerDiccionario() throws FileNotFoundException {
        FileReader leerArchivo = new FileReader(Archivotxt.nombreArchivo);
        BufferedReader leer = new BufferedReader(leerArchivo);

        while (traducccion != null) {
            try {
                traducccion = leer.readLine();
                if (traducccion == null) {
                    break;
                }else{
                    if (!traducccion.isBlank()){
                        String[] words = traducccion.split("=");
                        diccionario = new Diccionario(words[0].trim(),words[1].trim());
                        Archivotxt.listWords.add(diccionario);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
