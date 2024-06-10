package br.edu.unifei.ecot13.eleicao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Bandido extends Pessoa {
	
	private static final long serialVersionUID = 748722144797747790L;

	private String especializacao;
	
	//@OneToMany
	//private List<Arma> armas = new ArrayList<Arma>();   

}
