package es.iespuertodelacruz.nefta;

import java.util.HashMap;

import es.iespuertodelacruz.nefta.elementos.Alumno;
import es.iespuertodelacruz.nefta.elementos.Profesor;
import es.iespuertodelacruz.nefta.exceptions.AlumnoException;
import es.iespuertodelacruz.nefta.exceptions.FicheroException;

public class Clase {
    Profesor profesor;
    HashMap<Integer, Alumno> alumnos;
    Fichero fichero;

    public Clase() {
        alumnos = new HashMap<Integer, Alumno>() {

            private static final long serialVersionUID = 1L;

            @Override
            public String toString() {
                return super.toString().substring(1, super.toString().length() - 1);
            }
        };
    }

    /**
     * 
     * @param alumno
     * @throws AlumnoException
     */
    public void insertar(Alumno alumno) throws AlumnoException {
        if (existe(alumno)) {
            throw new AlumnoException("El alumno ya existe en la lista");
        }
        alumnos.put(alumno.getPosicion(), alumno);
    }

    /**
     * Funcion que busca a un alumno por su posicion
     * 
     * @param posicion a buscar
     * @return alumno
     */
    public Alumno buscar(Integer posicion) {

        Alumno alumno = null;
        alumno = alumnos.get(posicion);
        return alumno;
    }

    /**
     * Funcion que verifica si existe un alumno
     * 
     * @param alumno a encontrar
     * @return true/false
     */
    public boolean existe(Alumno alumno) {

        Alumno alumnoAEncontrar;
        alumnoAEncontrar = buscar(alumno.getPosicion());

        if (alumnoAEncontrar != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que elimina un alumno de la lista
     * 
     * @param posicion del alumno
     */
    public void eliminar(Integer posicion) {
        alumnos.remove(posicion);
    }

    /**
     * Funcion que retorna la lista de alumnos
     * 
     * @return lista de alumnos
     */
    public String mostrarLista() {
        return alumnos.toString();
    }

    /**
     * Metodo que crea un fichero con la lista
     * 
     * @param nombrefichero nombre que se le dara al fichero
     * @throws FicheroException excepcion controlada
     */
    public void volcarAfichero(String nombrefichero) throws FicheroException {
        if (fichero == null) {
            fichero = new Fichero();
        }

        fichero.crear(nombrefichero, mostrarLista());
    }

}
