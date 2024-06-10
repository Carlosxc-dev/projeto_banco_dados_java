package br.edu.unifei.ecot13.eleicao;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Metal extends Bala {
	
	private static final long serialVersionUID = -7196634200962835823L;
	
	public int estrago;

}
