package Logica;

import Clases.Recarga;
import Logica.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class RecargaJpaController implements Serializable {

    public RecargaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CeluRecargaPU");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Recarga recarga) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(recarga);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Recarga recarga) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            recarga = em.merge(recarga);
            em.getTransaction().commit();
        } catch (Exception ex) {
            Integer id = recarga.getIdRecarga();
            if (findRecarga(id) == null) {
                throw new NonexistentEntityException("La recarga con id " + id + " ya no existe.");
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Recarga recarga;
            try {
                recarga = em.getReference(Recarga.class, id);
                recarga.getIdRecarga();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("La recarga con id " + id + " no existe.", enfe);
            }
            em.remove(recarga);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Recarga> findRecargaEntities() {
        return findRecargaEntities(true, -1, -1);
    }

    public List<Recarga> findRecargaEntities(int maxResults, int firstResult) {
        return findRecargaEntities(false, maxResults, firstResult);
    }

    private List<Recarga> findRecargaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Recarga.class));
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

    public Recarga findRecarga(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Recarga.class, id);
        } finally {
            em.close();
        }
    }

    public int getRecargaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Recarga> rt = cq.from(Recarga.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}