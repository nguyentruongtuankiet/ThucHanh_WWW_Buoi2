import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.repositories.ConnectDB;

public class Maping {
    public static void main(String[] args) {

        EntityManager em = ConnectDB.getConnectDB().getEmf().createEntityManager();
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            tr.commit();
        }catch (Exception e){
            tr.rollback();
            e.printStackTrace();
        }
    }
}
