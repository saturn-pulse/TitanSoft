package com.saturnPulse.SaturnPulse.Enities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@DynamicInsert
@Data
@Table(name = "titan_user")
public class User {


    @Column(name = "user_id")
    Long id;

    @Column(name = "user_name")
    String userName;
}
