package Clases;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivotxt {
    public static String nombreArchivo = "diccionario.txt";
    private Diccionario diccionario;
    public static ArrayList<Diccionario> listWords = new ArrayList<>();

    public void addWord (String spanish, String english){
        if (!existWord(spanish,english)){
            diccionario = new Diccionario(spanish,english);
            listWords.add(diccionario);
            try {
                FileWriter writer = new FileWriter(nombreArchivo,true);
                writer.write("\r\n" + spanish + " = "+ english);
                writer.close();
            } catch (IOException e) {
                System.out.println("Escriba 1texto");
            }
        }
    }

    public void searchWord(String word){
        for (Diccionario p : listWords){
            if (p.getSpanish().equals(word)) {
                System.out.println("Traduccion: "+p.getEnglish());
            }
        }
    }

    public void showAllWords(){
        System.out.println("LISTADO");
        listWords.forEach(System.out::println);

    }

    private boolean existWord(String spanish, String english){
        Boolean exist = false;
        for (Diccionario diccionario : listWords){
            if (diccionario.getSpanish().equals(spanish) && diccionario.getEnglish().equals(english)){
                exist = true;
            }
        }
        return exist;
    }

}
