package com.cdspseminar.notefolio.domain;

import com.cdspseminar.notefolio.domain.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Creative extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long view;

    private Long numLike = 0L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private Creator creator;

    public void increaseNumLike(){
        this.numLike++;
    }
    public void decreaseNumLike(){
        this.numLike--;
    }
}
