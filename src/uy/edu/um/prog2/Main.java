package uy.edu.um.prog2;

import com.opencsv.exceptions.CsvValidationException;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.prog2.entities.Cancion;
import uy.edu.um.prog2.entities.ControladorCanciones;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String inputDate() {

        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese el año de la fecha:");
        int year = input.nextInt();

        System.out.println("Ingrese el mes de la fecha:");
        int month = input.nextInt();

        System.out.println("Ingrese el día de la fecha:");
        int day = input.nextInt();

        return year + "-" + month + "-" + day;

    }

    public static void main(String[] args) {

        ControladorCanciones nuevoControlador = new ControladorCanciones();

        String option;
        Scanner input = new Scanner(System.in);

        do {

            System.out.println(
                    "SELECCIONE UNA OPCIÓN:\n" +
                    "1- Obtener el top de las 10 canciones más escuchadas en un día (YYYY-MM-DD)\n" +
                    "2- Obtener el top de las 5 canciones que aparecen en más top 50 en un día dado\n" +
                    "3- Obtener el top de 7 artistas que más aparecen en los top 50 para un rango de fechas dado\n" +
                    "4- Obtener la cantidad de veces que aparece un artista específico en un top 50 en una fecha dada\n" +
                    "5- Obtener la cantidad de canciones con un tempo en un rango específico para un rango específico de fechas"
            );

            option = input.nextLine();

            switch (option) {

                case "1":

                    String fechaDada = inputDate();

                    MyList<Cancion> topDiezCanciones = new MyLinkedListImpl<>();

                    for (int i = 0; i < nuevoControlador.obtenerCantidadCanciones(); i++) {

                        Cancion cancionObtenida = nuevoControlador.obtenerCancion(i);

                        if (cancionObtenida == null || !cancionObtenida.obtenerFecha().equals(fechaDada)) {

                            continue;

                        }

                        if (topDiezCanciones.size() < 10) {

                            topDiezCanciones.add(cancionObtenida);

                        }

                    }

                    break;

                case "2":



                    break;

                case "3":



                    break;

                case "4":



                    break;

                case "5":



                    break;

            }

        } while (!option.equals("0"));

    }

}