package edu.escuelaing.arep;


import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.port;

import java.util.ArrayList;

import com.google.gson.Gson;

import edu.escuelaing.arep.model.Mensaje;
import edu.escuelaing.arep.persistencia.MensajePersistencia;
import edu.escuelaing.arep.persistencia.impl.ConetionDB;

/**
 * Clase Spark web server
 */
public class SparkWebServer 
{
	static MensajePersistencia persistencia= new ConetionDB(); 
	/**
	 * Inicializa el servidor web de spark y publica los mensajes
	 * @param args ejecucion
	 */
	public static void main( String[] args  ) {
        port(getPort()); 
        get("/mensajes", (req,res) -> {
        res.status(200);
        res.type("application/json");//aqui
        return new Gson().toJson(persistencia.leerMensajes());
        });
        
        post("/mensajes",(request, response) -> {
        	persistencia.escribirMensajes(new Mensaje(request.body()));
            return "";
        });
  }
	
  /**
   * retorna el puerto en uso
   * @return el puerto usado 
   */
  private static int getPort() {
      if (System.getenv("PORT") != null) {
          return Integer.parseInt(System.getenv("PORT"));
      }
      return 6001;//aqui
  }
}
	

