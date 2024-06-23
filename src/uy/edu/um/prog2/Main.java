package uy.edu.um.prog2;

import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.lang3.time.StopWatch;
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

    public static void main(String[] args) {

        long tiempoInicio = System.currentTimeMillis();

        ControladorCanciones nuevoControlador = new ControladorCanciones();

        long tiempoFin = System.currentTimeMillis();

        System.out.println("Se cargaron los datos en " + (float) (tiempoFin - tiempoInicio) / 1000 + " segundos");

        String option;
        Scanner input = new Scanner(System.in);

        do {

            System.out.println(
                    "SELECCIONE UNA OPCIÓN:\n" +
                    "1- Obtener el top de las 10 canciones más escuchadas en un día\n" +
                    "2- Obtener el top de las 5 canciones que aparecen en más top 50 en un día dado\n" +
                    "3- Obtener el top de 7 artistas que más aparecen en los top 50 para un rango de fechas dado\n" +
                    "4- Obtener la cantidad de veces que aparece un artista específico en un top 50 en una fecha dada\n" +
                    "5- Obtener la cantidad de canciones con un tempo en un rango específico para un rango específico de fechas\n" +
                    "6- Salir"
            );

            option = input.nextLine();

            switch (option) {

                case "1":

                    nuevoControlador.obtenerTopDiezCancionesDePais();

                    break;

                case "2":

                    nuevoControlador.obtenerTopCincoCancionesDeTop50();

                    break;

                case "3":

                    nuevoControlador.obtenerTopSieteArtistasDeTop50();

                    break;

                case "4":

                    nuevoControlador.obtenerAparicionesArtistaDeTop50();

                    break;

                case "5":

                    nuevoControlador.obtenerCancionesConTempo();

                    break;

            }

        } while (!option.equals("6"));

    }

}