package com.example.click_up.entity;

import com.example.click_up.entity.template.AbstractUUIDEntity;
import com.example.click_up.enums.TaskPermission;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CategoryUser extends AbstractUUIDEntity {

    @ManyToOne(optional = false)
    private Category category;

    @ManyToOne(optional = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private TaskPermission permission;

}
