package es.iespuertodelacruz.nefta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.nefta.elementos.Alumno;
import es.iespuertodelacruz.nefta.exceptions.AlumnoException;
import es.iespuertodelacruz.nefta.exceptions.FicheroException;

/**
 * Unit test for simple App.
 */
public class ClaseTest {

    Clase clase;

    @BeforeEach
    public void seTup() {
        if (clase == null) {
            clase = new Clase();
        }
        try {
            clase.insertar(crearAlumno());
        } catch (AlumnoException e) {
            fail("Se ha producido un error al crear la lista de inicio");
        }
    }

    @Test
    public void insertarAlumnoTest() {
        assertEquals(1, clase.alumnos.size(), "No se ha insertado el alumno");
    }

    @Test
    public void VolcarAficheroTest() {
        try {
            clase.volcarAfichero("nombreFichero.txt");
        } catch (FicheroException e) {
            fail("Error guardando el fichero de test");
        }
    }

    @Test
    public void mostrarListaTest() {
        assertTrue(clase.mostrarLista().contains(crearAlumno().toString()));
    }

    @Test
    public void insertarTestErrorAlumno() {
        try {
            clase.insertar(crearAlumno());
        } catch (AlumnoException e) {
            assertTrue(e.getMessage().contains("El alumno ya existe en la lista"));
        }
    }

    @Test
    public void eliminarAlumnoTest() {
        clase.eliminar(1);
        assertEquals(clase.alumnos.size(), 0, "No se ha eliminado al alumno correctamente");
    }

    /**
     * Funcion que crea un alumno para los tests
     * 
     * @return alumno
     */
    private Alumno crearAlumno() {
        return new Alumno("Test", "Test", 1);
    }

}
