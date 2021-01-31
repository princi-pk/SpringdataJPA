package com.cognizant.truyum.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

	@Query("select c from Cart c left join fetch c.user u where u.id=:id")
	public List<Cart>findById(@Param("id") int id);
//	@Query(nativeQuery = true,value = "select * from cart")
//	List<Cart> getAllCart();
	@Transactional
	@Modifying
	@Query(value="delete  from Cart where ct_us_id= :userId  and ct_pr_id  = :menuItemId limit 1",nativeQuery = true)
	public void removeItem(@Param("userId") int userId,@Param("menuItemId") long menuItemId);
//	x@Query("insert into cart values(ct_us_id= : userId,ct_pr_id  = :menuItemId)")
//	public void addItem(int userId, long menuItemId);
	
	
}
