package com.example.click_up.entity;

import com.example.click_up.entity.template.AbstractLongEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SpaceView extends AbstractLongEntity {
    @ManyToOne
    private Space space;

    @ManyToOne
    private View view;
}
