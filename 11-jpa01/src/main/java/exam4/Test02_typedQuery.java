package exam4;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test02_typedQuery {

	public static void main(String[] args) {
		EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("JpaEx01");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        try {
            transaction.begin();

            //데이블 명이 아니라 클래스 명으로 from 뒤에 작성한다.
            TypedQuery<Member4> query = em.createQuery(
            		"select m from Member4 m order by m.name",
            		Member4.class);
            List<Member4> result = query.getResultList(); 
            
            transaction.commit();
            
            //결과값이 비어있으면
            if(result.isEmpty()) {
            	System.out.println("사용자가 없습니다.");
            }else {
            	result.forEach(user->System.out.printf("| %s | %s | %ty - %<tm - %<td | \n",
            			user.getEmail(),user.getName(),user.getCreateDate()));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
        	em.close();
        }

        emf.close();
	}

}
