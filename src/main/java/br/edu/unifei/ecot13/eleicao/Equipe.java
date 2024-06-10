package br.edu.unifei.ecot13.eleicao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Equipe implements Serializable{
	
	
	private static final long serialVersionUID = -2954130004568339802L;
	
	@Id
	private String nomeEquipe;
	private String lider;
	
	@OneToMany
	private  List<Bandido> membros = new ArrayList<Bandido>();

	
}
