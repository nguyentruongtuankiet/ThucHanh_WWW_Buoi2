package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class GenericCRUD<T> {
    protected final EntityManager em;
    protected Logger logger;
    public GenericCRUD(){
        em = ConnectDB.getConnectDB().getEmf().createEntityManager();
    }
    public boolean add(T t){
        EntityTransaction tr = em.getTransaction();;
        tr.begin();
        try {
            em.persist(t);
            tr.commit();
            return true;
        }catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }
    public boolean update(T t){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.merge(t);
            tr.commit();
            return true;

        }catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }
    public boolean remove(Class<T> t, Object id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.remove(em.find(t, id));
            tr.commit();
            return true;
        }catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }


    public List<T> getAll(Class<T> clazz){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            List<T> list = em.createQuery("FROM " + clazz.getName(), clazz).getResultList();
            tr.commit();
            return list;
        }
        catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }
}
