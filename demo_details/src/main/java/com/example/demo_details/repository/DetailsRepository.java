package com.example.demo_details.repository;

import com.example.demo_details.dao.DetailsDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DetailsRepository extends JpaRepository<DetailsDAO, Long> {
    // 아래의 쿼리는 prodcode table과 join하는 쿼리로 변경해야 한다.
    // @Query(nativeQuery = true, value = "select * from details where prod_code = ?1")
    @Query(nativeQuery = true, value = "select d.id, d.prod_code, d.img_path, d.create_date, p.prod_name from details d, product_code p where d.prod_code = p.prod_code and d.prod_code = ?1")
    DetailsDAO findByProdCode(String prodCode);
}
