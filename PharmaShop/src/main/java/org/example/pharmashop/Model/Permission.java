package org.example.pharmashop.Model;

import jakarta.persistence.*;
import lombok.Data;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "t_permissions")
@Data
public class Permission implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String permission;

    @Override
    public String getAuthority(){
        return permission;
    }
}