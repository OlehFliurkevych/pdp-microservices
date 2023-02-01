package com.fliurkevych.microvisualizer.repository;

import com.fliurkevych.microvisualizer.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Oleh Fliurkevych
 */
@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {

}
