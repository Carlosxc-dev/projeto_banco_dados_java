package br.edu.unifei.ecot13.eleicao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public abstract class Bala implements Serializable {

	private static final long serialVersionUID = -7147254287624040936L;
	
	@Id
	private int tipo;

}
