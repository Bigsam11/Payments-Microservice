package com.paymentservice.repository;

import com.paymentservice.entity.ContentCreator;
import com.paymentservice.entity.Contents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContentRepository extends JpaRepository<Contents, Long> {

    @Query("SELECT c FROM Contents c WHERE c.isActive = true ")
    List<Contents> findAllActiveContent();
    @Query("SELECT c FROM Contents c WHERE c.id =:id and c.isActive = true")
    Optional<Contents> findActiveById(@Param("id") Long id);


}
