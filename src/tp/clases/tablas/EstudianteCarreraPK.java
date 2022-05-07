package tp.clases.tablas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EstudianteCarreraPK implements Serializable{

	@Column
	private int e;

	@Column
	private int c;
	
	public EstudianteCarreraPK(int i, int j) {
		super();
		this.e = i;
		this.c = j;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
	
}
