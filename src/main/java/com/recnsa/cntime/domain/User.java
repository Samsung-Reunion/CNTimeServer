package com.recnsa.cntime.domain;

import com.recnsa.cntime.domain.Enum.Social;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @Column(length = 50)
    private String name;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 5000, nullable = false)
    private String image;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Social provider;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Member> member;

    public String changeUserName(String newName) {
        this.name = newName;
        return this.name;
    }
}
