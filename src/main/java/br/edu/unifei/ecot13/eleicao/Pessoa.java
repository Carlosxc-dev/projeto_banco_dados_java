package br.edu.unifei.ecot13.eleicao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public abstract class Pessoa implements Serializable{
	
	private static final long serialVersionUID = -5510934750587621733L;
	
	@Id
	private String nome;
	private String sexo;
	
}
