package br.edu.unifei.ecot13.eleicao;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Refens extends Pessoa{

	private static final long serialVersionUID = 7205414666916668363L;
	
	private String profissao;
}
