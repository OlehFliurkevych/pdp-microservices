package com.fliurkevych.pdp.pdpmicrocollector.repository;

import com.fliurkevych.pdp.pdpmicrocollector.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Oleh Fliurkevych
 */
@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {

}
