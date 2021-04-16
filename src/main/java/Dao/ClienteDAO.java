/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 */
public class ClienteDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public ClienteDAO() {
        emf = Persistence.createEntityManagerFactory("hibernatejpa");
        em = emf.createEntityManager();
    }

    public void gravar(Cliente c) {

        try {

            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {

            em.close();
            emf.close();
        }
    }

    public Cliente remover(int id) {

        Cliente c = null;
        try {

            em.getTransaction().begin();
            c = em.find(Cliente.class, id);
            em.remove(c);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {

            em.close();
            emf.close();
        }

        return c;
    }

    public void atualizar(Cliente c, int id, float valor) {

        try {
            c = em.find(Cliente.class, 1);
            em.getTransaction().begin();
            c.setNome("fdsa");
            c.setCpf("324");
            c.setValorGasto(c.getValorGasto() + valor);

            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            em.close();
            emf.close();
        }

    }

    public List<Cliente> buscarTodos() {

        List<Cliente> c = null;

        try {
            c = em.createQuery("from Cliente").getResultList();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {

            em.close();
            emf.close();
        }

        return c;
    }

    public Cliente buscarId(int id) {

        Cliente c = null;
        try {
            em.getTransaction().begin();
            c = em.find(Cliente.class, id);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            em.close();
            emf.close();
        }

        return c;
    }

}
