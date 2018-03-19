package com.richardcsantana.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * Created by richardsantana on 23/03/16.
 */
@Entity
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name = "dado")
@EntityListeners(AuditingEntityListener.class)
public class Dado implements Serializable {

    public Dado(String teste) {
        this.teste = teste;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String teste;

    @CreatedBy
    @JsonIgnore
    private String userCreated;

    @LastModifiedBy
    @JsonIgnore
    private String userModified;

    @CreatedDate
    @JsonIgnore
    private ZonedDateTime createdDateTime;

    @LastModifiedDate
    @JsonIgnore
    private ZonedDateTime modifiedDateTime;
}
