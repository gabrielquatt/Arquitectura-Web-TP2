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
import org.hibernate.sql.ordering.antlr.Factory;

import antlr.collections.List;
import tp.clases.tablas.Carrera;
import tp.clases.tablas.Estado;
import tp.clases.tablas.Estudiante;
import tp.dto.ReporteCarreraDTO;
import tp.factory.FactoryImp;
import tp.repositoryImp.CarreraRepositoryImp;
import tp.repositoryImp.EstadoRepositoryImp;
import tp.repositoryImp.EstudianteRepositoryImp;

public class main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		FactoryImp f = FactoryImp.GetFactory();

		// "Lista todos los estudiantes Ordenados por Numero De Libreta Decendentemente"

		/**
		 * 1) Considere el diseño de un registro de estudiantes, con la siguiente
		 * información: nombres, apellido, edad, género, número de documento, ciudad de
		 * residencia, número de libreta universitaria, carrera(s) en la que está
		 * inscripto, antigüedad en cada una de esas carreras, y si se graduó o no.
		 * Diseñar el diagrama de objetos y el diagrama DER correspondiente.
		 *
		 * 2) Implementar consultas para: a) dar de alta un estudiante b) matricular un
		 * estudiante en una carrera
		 */

		LoadCSV(f);

		// c) recuperar todos los estudiantes, y especificar algún criterio de
		// ordenamiento simple.
		for (Estudiante e : f.GetEstudianteRepository().GetEstudiantes()) {
			System.out.println(e);
		}

		// d) recuperar un estudiante, en base a su número de libreta universitaria.
		Estudiante e2 = f.GetEstudianteRepository().GetEstudianteById(11105749);
		System.out.println(e2);

		// e) recuperar todos los estudiantes, en base a su género.
		for (Estudiante e : f.GetEstudianteRepository().GetEstudiantesByGenero("Male")) {
			System.out.println(e);
		}

		// f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad
		// de inscriptos.
		for (Carrera c : f.GetCarreraRepository().GetCarrerasOrderByInscriptos()) {
			System.out.println(c);
		}

		// g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad
		// de residencia.
		for (Estudiante e : f.GetEstudianteRepository().GetEstudiantesByCiudad("Pavlovskaya", 5)) {
			System.out.println(e);
		}

		/**
		 * 3) Generar un reporte de las carreras, que para cada carrera incluya
		 * información de los inscriptos y egresados por año. Se deben ordenar las
		 * carreras alfabéticamente, y presentar los años de manera cronológica.
		 */
		for (ReporteCarreraDTO r : f.GetCarreraRepository().ReporteCarrera()) {
			System.out.println(r);
		}

	}

	public static void LoadCSV(FactoryImp f) throws FileNotFoundException, IOException, ParseException {

		ArrayList<Estudiante> list_e = new ArrayList<>();
		ArrayList<Carrera> list_c = new ArrayList<>();
		ArrayList<Integer> estados = new ArrayList<>();

		CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("data/CARRERA1.csv"));
		for (CSVRecord row : parser) {
			Carrera c = new Carrera(row.get("carrera"));
			list_c.add(c);
			f.GetCarreraRepository().InsertarCarrera(c);
		}
		parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("data/ESTUDIANTES.csv"));
		for (CSVRecord row : parser) {
			int num_l = Integer.parseInt(row.get("num_Libreta"));
			int num_d = Integer.parseInt(row.get("num_doc"));
			int edad = Integer.parseInt(row.get("edad"));
			Estudiante e = new Estudiante(num_l, num_d, row.get("name"), row.get("apellido"), edad, row.get("genero"),
					row.get("recidencia"));
			list_e.add(e);
			f.GetEstudianteRepository().InsertarEstudiante(e);
		}

		parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("data/ESTADO.csv"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
		formatter = formatter.withLocale(Locale.US);

		for (CSVRecord row : parser) {
			int num = 30;
			while (num > 0) {
				int n = (int) (Math.random() * 18); // 8 carreras en el csv
				int n2 = (int) (Math.random() * 29); // 30 estudiantes
				LocalDate anioIngreso = LocalDate.parse(row.get("anioIngreso"), formatter);
				LocalDate anioEgreso = LocalDate.parse(row.get("anioEgreso"), formatter);
				Estado e;

				if (!estados.contains(n + n2)) {
					estados.add(n + n2);

					if (anioIngreso.isBefore(anioEgreso)) {
						e = new Estado(list_c.get(n), list_e.get(n2), anioIngreso, anioEgreso);
					} else {
						e = new Estado(list_c.get(n), list_e.get(n2), anioIngreso);
					}
					f.GetEstadoRepository().InsertEstado(e);
				}
				num--;
			}
		}

	}

}

