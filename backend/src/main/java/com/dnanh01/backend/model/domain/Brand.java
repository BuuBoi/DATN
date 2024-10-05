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
@Table(name = "brands")
public class Brand extends BaseClazz {

    @Column(name = "brand_name", nullable = false)
    private String brandName;

    @Column(name = "brand_logo", nullable = false)
    private String brandLogo;

    /**
     * relationship
     * 1-n [shoes]
     * 
     * @author DNAnh01[Do Nguyen Anh]
     */

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "shoes")
    private List<Shoe> shoes;
}
