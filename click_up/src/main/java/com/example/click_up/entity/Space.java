package com.example.click_up.entity;

import com.example.click_up.entity.template.AbstractUUIDEntity;
import com.example.click_up.enums.ObjectAccessType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Space extends AbstractUUIDEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String color;

    @ManyToOne
    private Workspace workspace;

    @Column(nullable = false)
    private String initialLetter;

    @OneToOne
    private Icon icon;

    @OneToOne()
    private Attachment attachment;

    @ManyToOne(optional = false)
    private User owner;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ObjectAccessType accessType;


}
