package uy.edu.um.prog2;

import uy.edu.um.prog2.entities.ControladorCanciones;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        long ejecucionInicio = System.currentTimeMillis();

        //NOTA IMPORTANTE: Por algún motivo el país de la canción se vuelve null cuando se guarda en una lista de canciones4
        // como objeto, no se pierde ningún otro dato, pero imposibilita la ejecución de la primer consulta.
        ControladorCanciones nuevoControlador = new ControladorCanciones();

        long ejecucionFin = System.currentTimeMillis();

        System.out.println("Se cargaron los datos en " + (float) (ejecucionFin - ejecucionInicio) / 1000 + " segundos");

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