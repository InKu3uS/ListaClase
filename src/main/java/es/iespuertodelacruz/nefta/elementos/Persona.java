package es.iespuertodelacruz.nefta.elementos;

public class Persona {
    String nombre;
    String apellidos;

    public Persona() {
    }

    public Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

}
