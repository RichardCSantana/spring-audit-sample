package com.richardcsantana.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by richardsantana on 23/03/16.
 */
@Entity
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name="dado")
@EntityListeners(AuditingEntityListener.class)
public class Dado implements Serializable{

    public Dado(String teste){
        this.teste = teste;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String teste;

    @CreatedDate
    private Date createdDateTime;

    @LastModifiedDate
    private Date modifiedDateTime;
}
