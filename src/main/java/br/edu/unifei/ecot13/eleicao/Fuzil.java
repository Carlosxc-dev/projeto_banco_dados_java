package br.edu.unifei.ecot13.eleicao;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Fuzil extends Arma {
	
	private static final long serialVersionUID = -6004462381099715459L;

	private int precisao;
	
}
