package br.edu.unifei.ecot13.eleicao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Banco implements Serializable{
	
	private static final long serialVersionUID = -3624837232970504109L;
	
	@Id
	private String nomeBanco;
	protected boolean fecharPortas;
	
	@OneToMany
	private List<Refens> refens= new ArrayList<Refens>();

}
