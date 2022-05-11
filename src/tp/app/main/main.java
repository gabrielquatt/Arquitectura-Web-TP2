package tp.app.main;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import antlr.collections.List;
import tp.clases.tablas.Carrera;
import tp.clases.tablas.Estado;
import tp.clases.tablas.Estudiante;
import tp.repositoryImp.CarreraRepositoryImp;
import tp.repositoryImp.EstadoRepositoryImp;
import tp.repositoryImp.EstudianteRepositoryImp;

public class main {
	 

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		EstudianteRepositoryImp er = new EstudianteRepositoryImp();
		CarreraRepositoryImp cr = new CarreraRepositoryImp();
		EstadoRepositoryImp estr = new EstadoRepositoryImp();
		
		//loadCSV(er,cr,estr);
		
		// //"Lista todos los estudiantes Ordenados por Numero De Libreta Decendentemente"
		// for(Estudiante e :er.getEstudiantes()) {
		//       System.out.println(e);
		//     }
		// System.out.println();
		// System.out.println();
		
		//Retorna los estudiantes por un ID
//		Estudiante e2 = er.getEstudianteById(11105749);
//		System.out.println(e2);
//		
//		System.out.println();
//		System.out.println();
		
		//"Lista todos los estudiantes filtrados por genero"
		// for(Estudiante e :er.getEstudiantesByGenero("Male")) {
		// 	System.out.println(e);
		// }
		
		//"Lista todos los estudiantes filtrados por genero"
		// for(Carrera c :cr.getCarreras()) {
		// 	System.out.println(c);
		// }
//
		for(Estudiante e :er.getEstudiantesByCiudad("Pavlovskaya", 3)){
			System.out.println(e);
		}
	
	}

	
	public static void loadCSV(EstudianteRepositoryImp er, CarreraRepositoryImp cr, EstadoRepositoryImp estr) throws FileNotFoundException, IOException, ParseException {
		
		ArrayList<Estudiante> list_e = new ArrayList<>();
		ArrayList<Carrera> list_c = new ArrayList<>();
		ArrayList<Integer> estados= new ArrayList<>();
			
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
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
	       formatter = formatter.withLocale( Locale.US );
		
		
	    int num = 100;
		for (CSVRecord row: parser) {
			while(num>0) {
			int n = (int) (Math.random()*7); //8 carreras en el csv
			int n2 = (int) (Math.random()*29); //30 estudiantes
			LocalDate anioIngreso = LocalDate.parse(row.get("anioIngreso"),formatter);
			LocalDate anioEgreso =  LocalDate.parse(row.get("anioEgreso"),formatter);
			Estado e;
			
			if(!estados.contains(n+n2)) {
				estados.add(n+n2);
				if(anioIngreso.isBefore(anioEgreso)) {
					e = new Estado(list_c.get(n),list_e.get(n2), anioIngreso ,anioEgreso);				
				}else {
					e = new Estado(list_c.get(n),list_e.get(n2), anioIngreso);	
				}												
				estr.insertEstado(e);
			}			
			num--;
			}
		}
		
	
		}

	}
	

