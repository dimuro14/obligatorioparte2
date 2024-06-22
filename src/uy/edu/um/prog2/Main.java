package uy.edu.um.prog2;

import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.prog2.entities.Cancion;

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

    public static void main(String[] args) throws IOException, CsvValidationException {

        String option;
        Scanner input = new Scanner(System.in);

        do {

            option = input.nextLine();

            switch (option) {

                case "1":

                    System.out.println("Obtener el top de las 10 canciones más escuchadas en un día (YYYY-MM-DD)");
                    Path filePath = Paths.get("C:", "Users", "luisd", "OneDrive", "Escritorio", "universal_top_spotify_songs.csv");

                    System.out.println(filePath);

                    CSVParser parser = new CSVParserBuilder()
                            .withSeparator(',')
                            .withIgnoreQuotations(false)
                            .build();

                    Reader reader = Files.newBufferedReader(filePath);
                    CSVReader csvReader = new CSVReaderBuilder(reader)
                            .withSkipLines(1)
                            .withCSVParser(parser)
                            .build();

                    MyList<Cancion> listaCanciones = new MyLinkedListImpl<>();

                    for (int i = 0; i < 748803; i++) {

                        String[] cancionLeida = csvReader.readNext();
                        //System.out.println(cancionLeida);
                        System.out.println(Arrays.toString(cancionLeida));

                        System.out.println(cancionLeida.length);

                        Cancion nuevaCancion = new Cancion(
                                cancionLeida[0],
                                cancionLeida[1],
                                cancionLeida[2],
                                Integer.parseInt(cancionLeida[3]),
                                Integer.parseInt(cancionLeida[4]),
                                Integer.parseInt(cancionLeida[5]),
                                cancionLeida[6],
                                cancionLeida[7],
                                Integer.parseInt(cancionLeida[8]),
                                Boolean.parseBoolean(cancionLeida[9]),
                                Integer.parseInt(cancionLeida[10]),
                                cancionLeida[11],
                                cancionLeida[12],
                                Double.parseDouble(cancionLeida[13]),
                                Double.parseDouble(cancionLeida[14]),
                                Integer.parseInt(cancionLeida[15]),
                                Double.parseDouble(cancionLeida[16]),
                                Integer.parseInt(cancionLeida[17]),
                                Double.parseDouble(cancionLeida[18]),
                                Double.parseDouble(cancionLeida[19]),
                                Double.parseDouble(cancionLeida[20]),
                                Double.parseDouble(cancionLeida[21]),
                                Double.parseDouble(cancionLeida[22]),
                                Double.parseDouble(cancionLeida[23]),
                                Integer.parseInt(cancionLeida[24])
                        );

                    }

                    option = "0";

                    break;

                case "2":

                    System.out.println("Obtener el top de las 5 canciones que aparecen en más top 50 en un día dado"); //O(n)
                    break;

                case "3":

                    System.out.println("Obtener el top de 7 artistas que más aparecen en los top 50 para un rango de fechas dado");
                    break;

                case "4":

                    System.out.println("Obtener la cantidad de veces que aparece un artista específico en un top 50 en una fecha dada");
                    break;

                case "5":

                    System.out.println("Obtener la cantidad de canciones con un tempo en un rango específico para un rango específico de fechas");
                    break;

            }

        } while (!option.equals("0"));

    }

}