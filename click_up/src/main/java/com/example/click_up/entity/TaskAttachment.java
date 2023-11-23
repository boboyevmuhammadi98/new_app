package com.example.click_up.entity;

import com.example.click_up.entity.template.AbstractUUIDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TaskAttachment extends AbstractUUIDEntity {
    @ManyToOne
    private Task task;

    @OneToOne
    private Attachment attachment;

    @Column(nullable = false)
    private boolean pinCoverImage;

}
