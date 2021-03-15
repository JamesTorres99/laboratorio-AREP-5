package edu.escuelaing.arep.persistencia;

import java.util.ArrayList;

import edu.escuelaing.arep.model.Mensaje;

/**
 * Clase persistencia
 * @author Alexander Torres
 *
 */
public interface MensajePersistencia {
	
	/**
	 * Metodo que permite escritura de mensajes
	 * @param mensaje 
	 */
	void escribirMensajes(Mensaje mensaje);
	
	/**
	 * Metodo que permite la lectura de mensajes	
	 * @return una lista de mensajes
	 */
	 ArrayList<Mensaje> leerMensajes();
	
}
