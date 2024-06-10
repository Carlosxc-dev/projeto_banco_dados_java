package br.edu.unifei.ecot13.eleicao;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Policial extends Pessoa{

	private static final long serialVersionUID = 8229668497484671255L;

	private String competencia;
	
	@OneToMany
	private List<Arma> armas = new ArrayList<Arma>();   


}
