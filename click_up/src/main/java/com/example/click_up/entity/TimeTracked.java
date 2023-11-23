package com.example.click_up.entity;

import com.example.click_up.entity.template.AbstractUUIDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TimeTracked extends AbstractUUIDEntity {
    @OneToOne()
    private Task task;

    @Column(nullable = false, updatable = false)
    private LocalDateTime startedAt;

    @Column(nullable = false, updatable = false)
    private LocalDateTime stoppedAt;
}
