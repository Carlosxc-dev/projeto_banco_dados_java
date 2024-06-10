package br.edu.unifei.ecot13.eleicao;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Pistola extends Arma {
	
	private static final long serialVersionUID = -886276650030953824L;

	private float potencia;
	


}
