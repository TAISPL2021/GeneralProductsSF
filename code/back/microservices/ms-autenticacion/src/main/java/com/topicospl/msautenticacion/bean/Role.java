package com.topicospl.msautenticacion.bean;

import com.topicospl.msautenticacion.enums.RoleName;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated ( EnumType.STRING)
    private RoleName roleName;
}
