package com.notimplement.happygear.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private long roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "role",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<User> users;
}
