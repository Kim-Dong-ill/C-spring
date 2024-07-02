package exam3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Add_select {

	public static void main(String[] args) {
		 EntityManagerFactory emf =
	                Persistence.createEntityManagerFactory("JpaEx01");
	        EntityManager entityManager = emf.createEntityManager();

	        Member3 user = entityManager.find(Member3.class, "test@naver.com");

	        if(user != null) {
	        	log.info("이름 : " + user.getName());
	        	System.out.printf("생성 : %ty - %<tm - %<td\n",user.getCreateDate());
	        }else {
	        	log.info("데이터 없음");
	        }
	        
	        entityManager.close();

	        emf.close();
	}

}
