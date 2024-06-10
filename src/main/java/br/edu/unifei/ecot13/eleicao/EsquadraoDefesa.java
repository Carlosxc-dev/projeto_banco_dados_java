package br.edu.unifei.ecot13.eleicao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class EsquadraoDefesa  implements Serializable{

	private static final long serialVersionUID = 386858952291414221L;
	
	@Id
	private String chefe;

	@OneToMany
	private List<Policial> grupo = new ArrayList<Policial>();   

	@OneToOne
	private Banco banco;
	
}
