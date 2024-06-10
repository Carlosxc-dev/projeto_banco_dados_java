/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.ecot13.eleicao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.bytebuddy.implementation.bytecode.Addition;


public class AppInsert {

    public static void main(String args[]) {

        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("eleicaoPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        PlanoAssalto plano = new PlanoAssalto();
        plano.setSenha(123);
        plano.setDefinicao("Deterreter o ouro do cofre e retirar pela tubulacao");
        em.persist(plano);
        
        Equipe equipe = new Equipe();
        equipe.setNomeEquipe("la casa de papel");
        equipe.setLider("professor");
        
        Bandido b1 =new Bandido();
        b1.setNome("toquio");
        b1.setEspecializacao("estrategia e linha de ataque");
        b1.setSexo("feminino");
        
        Bandido b2 =new Bandido();
        b2.setNome("helsinki");
        b2.setEspecializacao("derreter ouro");
        b2.setSexo("masculino");
        
        Bandido b3 =new Bandido();
        b3.setNome("raquel murillo");
        b3.setEspecializacao("namorada professsor");
        b3.setSexo("feminino");
        
        Bandido b4 =new Bandido();
        b4.setNome("rio");
        b4.setEspecializacao("especialista tecnologia");
        b4.setSexo("masculino");
        
        
        equipe.getMembros().add(b1);
        equipe.getMembros().add(b2);
        equipe.getMembros().add(b3);
        equipe.getMembros().add(b4);
        
        
        em.persist(b1);
        em.persist(b2);
        em.persist(b3);
        em.persist(b4);
        em.persist(equipe);
        
        Refens refem =new Refens();
        refem.setNome("estocomo");
        refem.setProfissao("contadora");
        refem.setSexo("feminino");
        em.persist(refem);
        
        Banco banco = new Banco();
        banco.setNomeBanco("banco espanha");
        banco.setFecharPortas(true);
        banco.getRefens().add(refem);
        em.persist(refem);
        em.persist(banco);
        
        Assalto assalto = new Assalto();
        // id ja gera por auto incremento
        assalto.setObjetivo("roubar casa da moeda");
        assalto.setAssaltarBanco(true);
        assalto.setQuntAlmejada(100000000);
        assalto.setPlano(plano);
        assalto.setBanco(banco);
        assalto.getEquipe().add(equipe);
        
        em.persist(plano);
        em.persist(banco);
        em.persist(equipe);
        em.persist(assalto);
        
        Policial poli = new Policial();
        poli.setNome("alicia sierra");
        poli.setCompetencia("chefe operacoes especiais");
        poli.setSexo("feminino"); 
        Arma a1 = new Arma();
        a1.setNomeArma("glock_1");
        a1.setCalibre(38);
        a1.setQuantBalas(10);      
        poli.getArmas().add(a1);
        em.persist(a1);
        em.persist(poli);
        
        EsquadraoDefesa esq = new EsquadraoDefesa();
        esq.setChefe("tamaio");
        esq.setBanco(banco);
        esq.getGrupo().add(poli);
        em.persist(banco);
        em.persist(poli);
        em.persist(esq);
       
        Borracha b = new Borracha();
        b.setTipo(38); // chave
        b.setDano(100);
        em.persist(b);
        
        Metal m = new Metal();
        m.setTipo(50); // chave
        m.setEstrago(1000);
        em.persist(m);
        
        Arma a = new Arma();
        a.setNomeArma("glock");
        em.persist(a);

        Fuzil  f = new Fuzil();
        f.setNomeArma("ak47_1");
        f.setCalibre(50);
        f.setPrecisao(1);
        f.setQuantBalas(100);
        f.getBalas().add(m);
        em.persist(m);
        em.persist(f);
        
        Pistola p = new Pistola();
        p.setNomeArma("glock_2");
        p.setPotencia(10);
        p.setQuantBalas(20);
        p.setCalibre(38);
        p.getBalas().add(b);
        em.persist(p);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
