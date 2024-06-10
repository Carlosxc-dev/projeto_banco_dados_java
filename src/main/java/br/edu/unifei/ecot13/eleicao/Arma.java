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
public class Arma implements Serializable {
	
	private static final long serialVersionUID = 2983882076435103400L;
	
	@Id
	private String nomeArma;
	
	private int calibre;
	private int quantBalas;
	
	@OneToMany
	private List<Bala> balas= new ArrayList<Bala>();   


	
	
}
