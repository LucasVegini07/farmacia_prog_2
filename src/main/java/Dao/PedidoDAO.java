/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Pedido;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 */
public class PedidoDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public PedidoDAO() {
        emf = Persistence.createEntityManagerFactory("hibernatejpa");
        em = emf.createEntityManager();

    }

    public void gravar(Pedido pedido) {

        try {

            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {

            em.close();
            emf.close();
        }
    }

    public Pedido remover(int id) {

        Pedido pedido = null;
        try {

            em.getTransaction().begin();
            pedido = em.find(Pedido.class, id);
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

    public void atualizar(Pedido pedido) {

        try {
            pedido = em.find(Pedido.class, 2L);
            em.getTransaction().begin();
            pedido.setNomeCliente("Lucas");
            pedido.setcpfFuncionario("João");
            pedido.setValor((float) 150.50);
            em.merge(pedido);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            em.close();
            emf.close();
        }

    }

    public List<Pedido> buscarTodos() {

        List<Pedido> pedido = null;

        try {
            pedido = em.createQuery("from Pedido").getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {

            em.close();
            emf.close();
        }

        return pedido;
    }

    public Pedido buscarId(int id) {

        Pedido pedido = null;
        try {
            em.getTransaction().begin();
            pedido = em.find(Pedido.class, id);
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
