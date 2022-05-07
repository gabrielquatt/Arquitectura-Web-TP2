package tp.app.main;
import java.io.FileNotFoundException;
import java.io.FileReader;
//
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVParser;
//import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import tp.clases.tablas.Carrera;
import tp.clases.tablas.Estado;
import tp.clases.tablas.Estudiante;
import tp.repositoryImp.CarreraRepositoryImp;
import tp.repositoryImp.EstadoRepositoryImp;
import tp.repositoryImp.EstudianteRepositoryImp;

public class main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		//CONSULTA

		loadCSV();
		
	}

	
	public static void loadCSV() throws FileNotFoundException, IOException, ParseException {
		
		EstudianteRepositoryImp er = new EstudianteRepositoryImp();
		CarreraRepositoryImp cr = new CarreraRepositoryImp();
		EstadoRepositoryImp estr = new EstadoRepositoryImp();
		
		ArrayList<Estudiante> list_e = new ArrayList<>();
		ArrayList<Carrera> list_c = new ArrayList<>();
			
		CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("data/CARRERA.csv"));
		for (CSVRecord row: parser) {
			Carrera c = new Carrera(row.get("carrera"));
			list_c.add(c);
			cr.insertarCarrera(c);
		}
		parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("data/ESTUDIANTES.csv"));
		for (CSVRecord row: parser) {
			int num_l = Integer.parseInt(row.get("num_Libreta"));
			int num_d = Integer.parseInt(row.get("num_doc"));
			int edad = Integer.parseInt(row.get("edad"));
			Estudiante e = new Estudiante(num_l , num_d , row.get("name"), row.get("apellido"), edad, row.get("genero"), row.get("recidencia"));		
			list_e.add(e);
			er.insertarEstudiante(e);
		}
		
		parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("data/ESTADO.csv"));
		int num = 29;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
	       formatter = formatter.withLocale( Locale.US );
		
		
		for (CSVRecord row: parser) {
			int n = (int) (Math.random()*30); 
			LocalDate anioIngreso = LocalDate.parse(row.get("anioIngreso"),formatter);
			LocalDate anioEgreso =  LocalDate.parse(row.get("anioEgreso"),formatter);
			Estado e ;
			
			if(anioIngreso.isBefore(anioEgreso)) {
				 e = new Estado(list_c.get(n),list_e.get(num), anioIngreso ,anioEgreso);				
			}else {
				 e = new Estado(list_c.get(n),list_e.get(num), anioIngreso);	
			}
			
			num--;
			estr.insertEstado(e);
		}
		
	
		}
	}
	

