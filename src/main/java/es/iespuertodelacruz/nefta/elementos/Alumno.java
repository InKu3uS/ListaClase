package es.iespuertodelacruz.nefta.elementos;

public class Alumno extends Persona {

    int posicion;

    public Alumno(String nombre, String apellidos, int posicion) {
        super(nombre, apellidos);
        this.posicion = posicion;
    }

    public int getPosicion() {
        return this.posicion;
    }

    @Override
    public String toString() {
        return this.posicion + ", " + this.nombre + ", " + this.apellidos + "\n";
    }
}
