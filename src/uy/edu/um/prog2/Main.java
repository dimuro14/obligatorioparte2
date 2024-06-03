package uy.edu.um.prog2;

import uy.edu.um.prog2.entities.*;
import uy.edu.um.prog2.exceptions.*;

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

        String option;
        Scanner input = new Scanner(System.in);

        do {

            option = input.nextLine();

            switch (option) {

                case "1":

                    System.out.println("Obtener el top de las 10 canciones más escuchadas en un día (YYYY-MM-DD)");

                case "2":

                    System.out.println("Obtener el top de las 5 canciones que aparecen en más top 50 en un día dado"); //O(n)

                case "3":

                    System.out.println("Obtener el top de 7 artistas que más aparecen en los top 50 para un rango de fechas dado");

                case "4":

                    System.out.println("Obtener la cantidad de veces que aparece un artista específico en un top 50 en una fecha dada");

                case "5":

                    System.out.println("Obtener la cantidad de canciones con un tempo en un rango específico para un rango específico de fechas");

            }

        } while (!option.equals("0"));

    }

}