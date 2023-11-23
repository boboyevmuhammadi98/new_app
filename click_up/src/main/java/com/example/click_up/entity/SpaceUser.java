package com.example.click_up.entity;

import com.example.click_up.entity.template.AbstractLongEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SpaceUser extends AbstractLongEntity {
    @ManyToOne
    private Space space;

    @ManyToOne
    private User user;
}
