package uy.edu.um.prog2.entities;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ControladorCanciones {

    private MyList<Cancion> listaCanciones = new MyLinkedListImpl<>();

    public ControladorCanciones() {

        Path filePath = Paths.get("C:", "Users", "luisd", "OneDrive", "Escritorio", "universal_top_spotify_songs.csv");

        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(false)
                .build();

        Reader reader = null;

        try {

            reader = Files.newBufferedReader(filePath);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }
        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withSkipLines(1)
                .withCSVParser(parser)
                .build();

        for (int i = 0; i < 748803; i++) {

            String[] cancionLeida;

            try {

                cancionLeida = csvReader.readNext();

            } catch (IOException | CsvValidationException e) {

                throw new RuntimeException(e);

            }

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

            listaCanciones.add(nuevaCancion);

        }

    }

    public Cancion obtenerCancion(int indice) {

        return listaCanciones.get(indice);

    };

    public int obtenerCantidadCanciones() {

        return listaCanciones.size();

    };

}
