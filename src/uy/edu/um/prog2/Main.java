package uy.edu.um.prog2;

import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;

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
                            .withIgnoreQuotations(true)
                            .build();

                    Reader reader = Files.newBufferedReader(filePath);
                    CSVReader csvReader = new CSVReaderBuilder(reader)
                            .withSkipLines(1)
                            .withCSVParser(parser)
                            .build();

                    MyList<String> songList = new MyLinkedListImpl<>();

                    //[spotify_id, "name", "artists", "daily_rank", "daily_movement", "weekly_movement", "country", "snapshot_date", "popularity", "is_explicit", "duration_ms", "album_name", "album_release_date", "danceability", "energy", "key", "loudness", "mode", "speechiness", "acousticness", "instrumentalness", "liveness", "valence", "tempo", "time_signature"";;]

                    for (int i = 0; i < 748803; i++) {

                        String[] newSong = csvReader.readNext();
                        System.out.println(Arrays.toString(newSong));
                        System.out.println(newSong[7]);

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