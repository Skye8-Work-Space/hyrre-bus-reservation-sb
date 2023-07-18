package com.skye8.elroykanye.hyrrebus.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Elroy Kanye
 * created on: 06-11-21
 *
 * modified by Tanju Brunostar
 * modified on: 11-11-21
 */
@Table(name = "agency_user")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class AgencyUser implements Serializable {
    private static final long serialVersionUID = -7754381310696267899L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "agency_user_id", nullable = false)
    private Long agencyUserId;

    @Column(name = "username", length = 64)
    private String username;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "agency_agency_id", nullable = true)
    private Agency agency;

}
