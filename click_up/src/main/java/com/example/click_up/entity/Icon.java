package com.example.click_up.entity;

import com.example.click_up.entity.template.AbstractUUIDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Icon extends AbstractUUIDEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String initialLetter;

    @Column(nullable = false)
    private String color;

    @OneToOne()
    private Attachment attachment;

}
