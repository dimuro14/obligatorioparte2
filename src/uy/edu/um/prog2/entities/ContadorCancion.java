package uy.edu.um.prog2.entities;

public class ContadorCancion implements Comparable<ContadorCancion> {
    private String nombre;
    private int repeticiones;

    public ContadorCancion(String nombre, int repeticiones) {

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
    public int compareTo(ContadorCancion otroContador) {

        return Integer.compare(this.repeticiones, otroContador.getRepeticiones());

    }

}
