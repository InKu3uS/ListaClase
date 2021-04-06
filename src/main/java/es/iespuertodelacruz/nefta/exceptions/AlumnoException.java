package es.iespuertodelacruz.nefta.exceptions;

public class AlumnoException extends Exception {

    private static final long serialVersionUID = 3540740276019270557L;

    public AlumnoException(String mensaje) {
        super(mensaje);
    }

    public AlumnoException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }
}
