package com.saturnpulse.titan.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;

@Entity
@DynamicUpdate
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "titan_admin")
@Builder
public class Admin implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id")
    private Integer admin_id;

    @Column(name = "admin_name")
    private String name;

    @Column(name = "admin_uniqueId")
    private String userName;

    @Column(name = "admin_email")
    private String email;

    @Column(name = "admin_password")
    private String password;
}
