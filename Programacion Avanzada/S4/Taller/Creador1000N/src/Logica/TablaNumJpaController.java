package Logica;

import Clases.TablaNum;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TablaNumJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public TablaNumJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Practica_ThreadsPU");
    }

    public TablaNumJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // CREATE
    public void create(TablaNum tablaNum) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tablaNum);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // UPDATE
    public void edit(TablaNum tablaNum) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tablaNum = em.merge(tablaNum);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTablaNum(tablaNum.getIdC()) == null) {
                throw new Exception("El registro con id " + tablaNum.getIdC() + " no existe.");
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // DELETE
    public void destroy(Integer id) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TablaNum tablaNum;
            try {
                tablaNum = em.getReference(TablaNum.class, id);
                tablaNum.getIdC();
            } catch (EntityNotFoundException enfe) {
                throw new Exception("El registro con id " + id + " no existe.", enfe);
            }
            em.remove(tablaNum);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // FIND ALL
    public List<TablaNum> findTablaNumEntities() {
        return findTablaNumEntities(true, -1, -1);
    }

    public List<TablaNum> findTablaNumEntities(int maxResults, int firstResult) {
        return findTablaNumEntities(false, maxResults, firstResult);
    }

    private List<TablaNum> findTablaNumEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TablaNum.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // FIND BY ID
    public TablaNum findTablaNum(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TablaNum.class, id);
        } finally {
            em.close();
        }
    }

    // COUNT
    public int getTablaNumCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TablaNum> rt = cq.from(TablaNum.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}