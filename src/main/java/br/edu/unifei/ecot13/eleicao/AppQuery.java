/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.ecot13.eleicao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AppQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eleicaoPU");
        EntityManager em  = emf.createEntityManager();
        
        Assalto a =  (Assalto) em.createQuery(
                "select a "
                + "from assalto a").getSingleResult();
        
        System.out.println(a.getObjetivo());

        em.close();
        emf.close();
    }
}
