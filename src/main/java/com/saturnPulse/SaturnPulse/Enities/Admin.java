package com.saturnPulse.SaturnPulse.Enities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;

@Entity
@DynamicUpdate
@DynamicInsert
@Data
@Table(name = "titan_admin")
public class Admin implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;




    private Long id;

    @Column(name = "admin_name")
    private String name;

    @Column(name = "admin_uniqueId")
    private String adminId;

    @Column(name = "admin_email")
    private String email;

    @Column(name = "admin_password")
    private String password;
}
