package com.dnanh01.backend.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "colors")
public class Color extends BaseClazz {

    @Column(name = "color_name", nullable = false)
    private String colorName;

    @Column(name = "hex_value", nullable = false)
    private String hexValue;

    /**
     * relationship
     * 1-n [shoes]
     *
     * @author DNAnh01[Do Nguyen Anh]
     */
    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "shoes")
    private List<Shoe> shoes;
}
