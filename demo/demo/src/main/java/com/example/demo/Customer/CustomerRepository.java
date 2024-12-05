package com.example.demo.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;




@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByLoginUsername(String loginUsername);
    boolean existsByNicNumber(String nicNumber);

    @Query("SELECT c FROM Customer c WHERE c.nicNumber =:nicNumber")
    Optional<Customer> findByNicNumber(@Param("nicNumber") String nicNumber);
}
