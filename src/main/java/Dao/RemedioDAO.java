/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Remedio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 */
public class RemedioDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public RemedioDAO() {
        emf = Persistence.createEntityManagerFactory("hibernatejpa");
        em = emf.createEntityManager();
    }

    public void gravar(Remedio r) {

        try {

            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {

            em.close();
            emf.close();
        }
    }

    public Remedio remover(int id) {

        Remedio pedido = null;
        try {

            em.getTransaction().begin();
            pedido = em.find(Remedio.class, id);
            em.remove(pedido);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {

            em.close();
            emf.close();
        }

        return pedido;
    }

    public void atualizar(Remedio r) {

        try {
            r = em.find(Remedio.class, 2L);
            em.getTransaction().begin();
            em.merge(r);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            em.close();
            emf.close();
        }

    }

    public List<Remedio> buscarTodos() {

        List<Remedio> pedido = null;

        try {
            pedido = em.createQuery("from Remedio").getResultList();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {

            em.close();
            emf.close();
        }

        return pedido;
    }

    public Remedio buscarId(int id) {

        Remedio pedido = null;
        try {
            em.getTransaction().begin();
            pedido = em.find(Remedio.class, id);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            em.close();
            emf.close();
        }

        return pedido;
    }

}
