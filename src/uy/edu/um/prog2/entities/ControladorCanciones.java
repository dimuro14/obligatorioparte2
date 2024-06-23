package uy.edu.um.prog2.entities;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import uy.edu.um.adt.hash.MyHash;
import uy.edu.um.adt.hash.MyHashImpl;
import uy.edu.um.adt.heap.MyHeap;
import uy.edu.um.adt.heap.MyHeapImpl;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ControladorCanciones {
    private MyHash<String, MyList<Cancion>> hashSnapshots = new MyHashImpl<>();

    public ControladorCanciones() {

        //Dirección del archivo .csv
        //EX.: Path filePath = Paths.get("C:", "Users", "user", "Desktop", "universal_top_spotify_songs.csv")
        Path filePath = null;

        if (filePath == null) {

            System.out.println("Debe ingresar la dirección del archivo .csv en el programa para su ejecución.");
            System.exit(0);

        }

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

        boolean finalizarLectura = false;

        do {

            String[] cancionLeida;

            try {

                cancionLeida = csvReader.readNext();

            } catch (IOException | CsvValidationException e) {

                throw new RuntimeException(e);

            }

            if (cancionLeida == null) {

                finalizarLectura = true;
                break;

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

            String fechaCancion = cancionLeida[7];

            if (hashSnapshots.get(fechaCancion) == null) {

                MyList<Cancion> listaCanciones = new MyLinkedListImpl<>();

                hashSnapshots.put(fechaCancion, listaCanciones);

            }

            MyList<Cancion> cancionesDeFecha = hashSnapshots.get(fechaCancion);

            cancionesDeFecha.add(nuevaCancion);

        } while (!finalizarLectura);

    }
    private String ingresarFecha() {

        Scanner input = new Scanner(System.in);

        System.out.println("Año:");
        String ano = String.valueOf(input.nextInt());
        ano = ano.trim();
        if (ano.length() != 4) {

            ano = "2024";

        }

        System.out.println("Mes:");
        String mes = String.valueOf(input.nextInt());
        mes = mes.trim();
        if (mes.length() == 1) {

            mes = "0" + mes;

        }

        System.out.println("Día:");
        String dia = String.valueOf(input.nextInt());
        dia = dia.trim();
        if (dia.length() == 1) {

            dia = "0" + dia;

        }

        return ano + "-" + mes + "-" + dia;

    }

    public void obtenerTopDiezCancionesDePais() {

        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese la fecha: ");
        String fechaDada = ingresarFecha();

        System.out.println("Ingrese el país: ");
        String paisDado = input.nextLine();
        paisDado = paisDado.trim();

        long ejecucionInicio = System.currentTimeMillis();

        MyList<Cancion> topDiezCancionesEnPais = new MyLinkedListImpl<>();

        for (int i = 0; i < 9; i++) {

            Cancion cancionObtenida = hashSnapshots.get(fechaDada).get(i);

            if (cancionObtenida == null || !cancionObtenida.getPais().equals(paisDado)) {

                continue;

            }

            System.out.println((i + 1) + "- " + cancionObtenida.getNombre() + ", artista/s: " + Arrays.toString(cancionObtenida.getArtistas()) + ", puesto: " + cancionObtenida.getPuestoDiario());

            topDiezCancionesEnPais.add(cancionObtenida);

        }

        System.out.println(topDiezCancionesEnPais.size());

        long ejecucionFin = System.currentTimeMillis();

        System.out.println("Se ejecutó la función en " + (float) (ejecucionFin - ejecucionInicio) / 1000 + " segundos");

    }

    public void obtenerTopCincoCancionesDeTop50() {

        System.out.println("Ingrese la fecha: ");
        String fechaDada = ingresarFecha();

        if (hashSnapshots.get(fechaDada) == null) {

            System.out.println("Debe ingresar una fecha válida");

            return;

        }

        long ejecucionInicio = System.currentTimeMillis();

        MyHash<String, ContadorCancion> cancionesContadas = new MyHashImpl<>();

        for (int i = 0; i < 50; i++) {

            Cancion cancionObtenida = hashSnapshots.get(fechaDada).get(i);

            String nombreCancionObtenida = cancionObtenida.getNombre();

            if (cancionesContadas.get(nombreCancionObtenida) == null) {

                cancionesContadas.put(nombreCancionObtenida, new ContadorCancion(nombreCancionObtenida, 1));

            } else {

                ContadorCancion contadorObtenido = cancionesContadas.get(nombreCancionObtenida);

                int repeticiones = contadorObtenido.getRepeticiones() + 1;

                contadorObtenido.setRepeticiones(repeticiones);

            }

        }

        MyHeap<ContadorCancion> cancionesOrdenadas = new MyHeapImpl<>(5,false);

        for (int i = 0; i < cancionesContadas.size(); i++) {

            String nombreCancionObtenido = cancionesContadas.keys().get(i);

            cancionesOrdenadas.insert(cancionesContadas.get(nombreCancionObtenido));

        }

        MyList<String> topCincoCanciones = new MyLinkedListImpl<>();

        System.out.println("Top 5 canciones que aparecen más en el top 50 del día " + fechaDada + ":");

        for (int i = 0; i < 5; i++) {

            ContadorCancion cancionAInsertar = cancionesOrdenadas.delete();

            topCincoCanciones.add(cancionAInsertar.getNombre());

            System.out.println((i + 1) + "- " +cancionAInsertar.getNombre() + ", cantidad de apariciones: " + cancionAInsertar.getRepeticiones());

        }

        long ejecucionFin = System.currentTimeMillis();

        System.out.println("Se ejecutó la función en " + (float) (ejecucionFin - ejecucionInicio) / 1000 + " segundos");

    }

    public void obtenerTopSieteArtistasDeTop50() {

        System.out.println("Ingrese la fecha de inicio: ");
        String fechaInicio = ingresarFecha();

        System.out.println("Ingrese la fecha de fin: ");
        String fechaFin = ingresarFecha();

        if (hashSnapshots.get(fechaInicio) == null) {

            System.out.println("Debe ingresar una fecha de inicio válida");

            return;

        }

        if (hashSnapshots.get(fechaFin) == null) {

            System.out.println("Debe ingresar una fecha de fin válida");

            return;

        }

        long ejecucionInicio = System.currentTimeMillis();

        MyList<String> listaDeFechas = new MyLinkedListImpl<>();

        if (!fechaInicio.equals(fechaFin)) {

            LocalDate principioFechas = LocalDate.parse(fechaInicio);
            LocalDate finFechas = LocalDate.parse(fechaFin);

            List<LocalDate> todasLasFechas = principioFechas.datesUntil(finFechas).toList();

            for (LocalDate fecha : todasLasFechas) {

                listaDeFechas.add(String.valueOf(fecha));

            }

        } else {

            listaDeFechas.add(fechaInicio);

        }

        MyHash<String, ContadorArtistas> artistasContados = new MyHashImpl<>();

        for (int i = 0; i < listaDeFechas.size(); i++) {

            String fechaDada = listaDeFechas.get(i);

            if (hashSnapshots.get(fechaDada) == null) {

                continue;

            }

            for (int j = 0; j < 50; j++) {

                Cancion cancionObtenida = hashSnapshots.get(fechaDada).get(j);

                String[] nombresArtistasObtenidos = cancionObtenida.getArtistas();

                for (int k = 0; k < nombresArtistasObtenidos.length; k++) {

                    if (artistasContados.get(nombresArtistasObtenidos[k]) == null) {

                        artistasContados.put(nombresArtistasObtenidos[k], new ContadorArtistas(nombresArtistasObtenidos[k], 1));

                    } else {

                        ContadorArtistas contadorObtenido = artistasContados.get(nombresArtistasObtenidos[k]);

                        int repeticiones = contadorObtenido.getRepeticiones() + 1;

                        contadorObtenido.setRepeticiones(repeticiones);

                    }

                }

            }

        }

        MyHeap<ContadorArtistas> artistasOrdenados = new MyHeapImpl<>(7,false);

        System.out.println(artistasContados.size());

        for (int i = 0; i < artistasContados.size(); i++) {

            String nombreArtistaObtenido = artistasContados.keys().get(i);

            artistasOrdenados.insert(artistasContados.get(nombreArtistaObtenido));

        }

        MyList<String> topCincoCanciones = new MyLinkedListImpl<>();

        System.out.println("Top 7 artistas que aparecen en más top 50 desde el dia " + fechaInicio + " al día " + fechaFin + ":");

        for (int i = 0; i < 7; i++) {

            ContadorArtistas cancionAInsertar = artistasOrdenados.delete();

            topCincoCanciones.add(cancionAInsertar.getNombre());

            System.out.println((i + 1) + "- " +cancionAInsertar.getNombre() + ", cantidad de apariciones: " + cancionAInsertar.getRepeticiones());

        }

        long ejecucionFin = System.currentTimeMillis();

        System.out.println("Se ejecutó la función en " + (float) (ejecucionFin - ejecucionInicio) / 1000 + " segundos");

    }

    public void obtenerAparicionesArtistaDeTop50() {

        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese el nombre del artista: ");
        String nombreArtista = input.nextLine();
        nombreArtista = nombreArtista.trim();

        System.out.println("Ingrese la fecha: ");
        String fechaDada = ingresarFecha();

        if (hashSnapshots.get(fechaDada) == null) {

            System.out.println("Debe ingresar una fecha de inicio válida");

            return;

        }

        long ejecucionInicio = System.currentTimeMillis();

        int repeticiones = 0;

        for (int i = 0; i < 50; i++) {

            Cancion cancionObtenida = hashSnapshots.get(fechaDada).get(i);

            String[] nombresArtistasObtenidos = cancionObtenida.getArtistas();

            for (int j = 0; j < nombresArtistasObtenidos.length; j++) {

                if (nombreArtista.equals(nombresArtistasObtenidos[j])) {

                    repeticiones++;

                }

            }

        }

        System.out.println("Apariciones de " + nombreArtista + " en el top 50 del día " + fechaDada + ": " + repeticiones);

        long ejecucionFin = System.currentTimeMillis();

        System.out.println("Se ejecutó la función en " + (float) (ejecucionFin - ejecucionInicio) / 1000 + " segundos");

    }

    public void obtenerCancionesConTempo() {

        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese el tempo mínimo: ");
        double tempoMin = Double.parseDouble(input.nextLine());

        System.out.println("Ingrese el tempo máximo: ");
        double tempoMax = Double.parseDouble(input.nextLine());

        System.out.println("Ingrese la fecha de inicio: ");
        String fechaInicio = ingresarFecha();

        System.out.println("Ingrese la fecha de fin: ");
        String fechaFin = ingresarFecha();

        if (hashSnapshots.get(fechaInicio) == null) {

            System.out.println("Debe ingresar una fecha de inicio válida");

            return;

        }

        if (hashSnapshots.get(fechaFin) == null) {

            System.out.println("Debe ingresar una fecha de fin válida");

            return;

        }

        long ejecucionInicio = System.currentTimeMillis();

        MyList<String> listaDeFechas = new MyLinkedListImpl<>();

        if (!fechaInicio.equals(fechaFin)) {

            LocalDate principioFechas = LocalDate.parse(fechaInicio);
            LocalDate finFechas = LocalDate.parse(fechaFin);

            List<LocalDate> todasLasFechas = principioFechas.datesUntil(finFechas).toList();

            for (LocalDate fecha : todasLasFechas) {

                listaDeFechas.add(String.valueOf(fecha));

            }

        } else {

            listaDeFechas.add(fechaInicio);

        }

        MyList<Cancion> cancionesConTempo = new MyLinkedListImpl<>();

        for (int i = 0; i < listaDeFechas.size(); i++) {

            String fechaDada = listaDeFechas.get(i);

            for (int j = 0; j < 50; j++) {

                Cancion cancionObtenida = hashSnapshots.get(fechaDada).get(j);

                double cancionTempo = cancionObtenida.getTempo();

                if (cancionTempo >= tempoMin && cancionTempo <= tempoMax) {

                    cancionesConTempo.add(cancionObtenida);

                }

            }

        }

        System.out.println("Canciones con tempo desde " + tempoMin + " a " + tempoMax + ", desde el día " + fechaInicio + " al día " + fechaFin + ":");

        for (int i = 0; i < cancionesConTempo.size(); i++) {

            Cancion cancionObtenida = cancionesConTempo.get(i);

            System.out.println(cancionObtenida.getNombre() + ", tempo: " + cancionObtenida.getTempo());

        }

        long ejecucionFin = System.currentTimeMillis();

        System.out.println("Se ejecutó la función en " + (float) (ejecucionFin - ejecucionInicio) / 1000 + " segundos");

    }

}
