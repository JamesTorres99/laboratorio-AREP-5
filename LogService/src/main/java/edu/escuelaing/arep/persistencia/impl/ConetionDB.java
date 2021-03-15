package edu.escuelaing.arep.persistencia.impl;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import edu.escuelaing.arep.model.Mensaje;
import edu.escuelaing.arep.persistencia.MensajePersistencia;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.DBCollection;

/**
 * Clase que crea la conexion con la base de datos.
 * @author Alexander Torres
 *
 */
public class ConetionDB implements MensajePersistencia {
	public MongoClientURI uri;
	public MongoClient cliente;

	/**
	 * Constructor de la instancia a la base de datos
	 */
	public ConetionDB() {

		uri = new MongoClientURI("mongodb://Admin:321465789@0.0.0.0:27017/?serverSelectionTimeoutMS=5000&connectTimeoutMS=10000&authSource=LabArep5&authMechanism=SCRAM-SHA-1&3t.uriVersion=3");//aqui		
		cliente= new MongoClient(uri);
	}
	
	/**
	 * Escribe los mensajes a la base de datos			
	 */
	@Override
	public void escribirMensajes(Mensaje mensaje) {
		cliente= new MongoClient(uri);
		MongoDatabase basedeDatos= cliente.getDatabase("LabArep5");
        MongoCollection<Document> collection =basedeDatos.getCollection("mensajes");
        Document document=new Document();
        document.put("mensaje",mensaje.getMensaje());
        collection.insertOne(document);
	}


	/**
	 * Carga y lee todos los mensajes
	 * @return arraylist de los mensajes
	 */
	@Override
	public ArrayList<Mensaje> leerMensajes() {
		    MongoDatabase database = cliente.getDatabase("LabArep5");
	        MongoCollection<Document> collection =database.getCollection("mensajes");
	        FindIterable fit = collection.find();
	        ArrayList<Document> docs = new ArrayList<Document>();
	        ArrayList<Mensaje> mensajes=new ArrayList<Mensaje>();
	        fit.into(docs);
	        for (Document document:docs) {
	            String mensaje= (String) document.get("mensaje");
	            mensajes.add(new Mensaje(mensaje));
	        }

	        return mensajes;
}
}