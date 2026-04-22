package Logica;

import Clases.Chip;
import Logica.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ChipJpaController implements Serializable {

    public ChipJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CeluRecargaPU");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Chip chip) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(chip);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Chip chip) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            chip = em.merge(chip);
            em.getTransaction().commit();
        } catch (Exception ex) {
            Integer id = chip.getIdChip();
            if (findChip(id) == null) {
                throw new NonexistentEntityException("El chip con id " + id + " ya no existe.");
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
            Chip chip;
            try {
                chip = em.getReference(Chip.class, id);
                chip.getIdChip();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El chip con id " + id + " no existe.", enfe);
            }
            em.remove(chip);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Chip> findChipEntities() {
        return findChipEntities(true, -1, -1);
    }

    public List<Chip> findChipEntities(int maxResults, int firstResult) {
        return findChipEntities(false, maxResults, firstResult);
    }

    private List<Chip> findChipEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Chip.class));
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

    public Chip findChip(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Chip.class, id);
        } finally {
            em.close();
        }
    }

    public int getChipCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Chip> rt = cq.from(Chip.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public int countChipsByCelular(int idCel) {
        EntityManager em = null;
        try {
            em = getEntityManager();

            Query q = em.createQuery(
                "SELECT COUNT(c) FROM Chip c WHERE c.idCelular.idCelular = :idCel"
            );
            q.setParameter("idCel", idCel);

            return ((Long) q.getSingleResult()).intValue();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}