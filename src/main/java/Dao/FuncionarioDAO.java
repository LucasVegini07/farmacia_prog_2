package Dao;

import Model.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 */
public class FuncionarioDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public FuncionarioDAO() {
        emf = Persistence.createEntityManagerFactory("hibernatejpa");
        em = emf.createEntityManager();
    }

    public void gravar(Funcionario f) {

        try {
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {

            em.close();
            emf.close();
        }
    }

    public Funcionario remover(int id) {

        Funcionario f = null;
        try {

            em.getTransaction().begin();
            f = em.find(Funcionario.class, id);
            em.remove(f);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {

            em.close();
            emf.close();
        }

        return f;
    }

    public void atualizar(Funcionario f, int id, float valor) {
        try {
            f = em.find(Funcionario.class, id);
            em.getTransaction().begin();
            f.setSalario(f.getSalario() + valor);
            em.merge(f);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            em.close();
            emf.close();
        }

    }

    public List<Funcionario> buscarTodos() {

        List<Funcionario> f = null;

        try {
            f = em.createQuery("from Funcionario").getResultList();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {

            em.close();
            emf.close();
        }

        return f;
    }

    public Funcionario buscarId(int id) {

        Funcionario f = null;
        try {
            em.getTransaction().begin();
            f = em.find(Funcionario.class, id);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            em.close();
            emf.close();
        }

        return f;
    }

}
