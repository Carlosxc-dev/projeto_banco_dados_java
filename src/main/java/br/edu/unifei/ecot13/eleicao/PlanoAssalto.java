package br.edu.unifei.ecot13.eleicao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PlanoAssalto implements Serializable{
	

	private static final long serialVersionUID = -4533541451218804560L;
	
	@Id
	private int senha;
	private String definicao;
	

}
