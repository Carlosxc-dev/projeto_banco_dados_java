package br.edu.unifei.ecot13.eleicao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Borracha extends Bala {
	
	private static final long serialVersionUID = -2730796035738639708L;
	
	@GeneratedValue
	public int dano;

}
