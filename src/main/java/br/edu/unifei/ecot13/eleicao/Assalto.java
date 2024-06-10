package br.edu.unifei.ecot13.eleicao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;


@Data
@Entity
public class Assalto implements Serializable {
	
	private static final long serialVersionUID = -7332445065562319930L;

	@Id
	@GeneratedValue
	private int numero;
	private String objetivo;
	private boolean assaltarBanco;
	private int quntAlmejada;
	
	@OneToMany
	private List<Equipe> equipe= new ArrayList<Equipe>();   

	@OneToOne
	private PlanoAssalto plano;
	
	@OneToOne
	private Banco banco;
	
}
