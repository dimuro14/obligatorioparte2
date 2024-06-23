package uy.edu.um.prog2.entities;

public class ContadorArtistas implements Comparable<ContadorArtistas> {
    private String nombre;
    private int repeticiones;

    public ContadorArtistas(String nombre, int repeticiones) {

        this.nombre = nombre;
        this.repeticiones = repeticiones;

    }

    public String getNombre() {

        return this.nombre;

    }

    public int getRepeticiones() {

        return this.repeticiones;

    }

    public void setRepeticiones(int repeticiones) {

        this.repeticiones = repeticiones;

    }

    @Override
    public int compareTo(ContadorArtistas otroContador) {

        return Integer.compare(this.repeticiones, otroContador.getRepeticiones());

    }

}
