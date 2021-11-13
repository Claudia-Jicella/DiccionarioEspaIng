package Clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InformacionBase {

    private int opcion = 0;
    private String spanish = "", english = "";

    //Metodologia inicial

    public void iniciar() {
        Scanner sc;
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader leerTexto = new BufferedReader(inputStreamReader);

        Archivotxt utils = new Archivotxt();

        Traductor archivo = new Traductor();
        try {
            archivo.leerDiccionario();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

        boolean exit = true;

        try{
            do{
                System.out.println("*******Bienvenido al traductor de Español a Ingles*******");

                System.out.println("\nSeleccione la opcion deseada:");
                System.out.println("\n1. Ingrese una palagra\n"+ "2. Buqueda de palabras\n"+ "3. Leer diccionario\n"+ "4. " + "Salir\n");
                sc = new Scanner(System.in);
                opcion = sc.nextInt();
                if(opcion == 1){

                    System.out.println("Ingrese la palabra en español y la traducción");
                    spanish = leerTexto.readLine();
                    english = leerTexto.readLine();
                    utils.addWord(spanish.toLowerCase(),english.toLowerCase());
                }else if(opcion == 2){
                    System.out.println("Ingrese la palabra a buscar: ");
                    spanish = leerTexto.readLine();
                    utils.searchWord(spanish.toLowerCase());
                }else if(opcion == 3){
                    utils.showAllWords();
                }else if(opcion == 4){
                    exit = false;
                }else{
                    System.out.println("Ingresa una opcion correcta");
                }
            } while (exit);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
