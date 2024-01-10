package datn.goodboy.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    UUID id;

    @OneToOne
    @JoinColumn(name = "id_roles")
    private Roles roles;

    @Column(name = "code", insertable = false, updatable = false)
    String code;

    @Column(name = "name")
    String name;

    @Column(name = "gender")
    boolean gender;

    @Column(name = "birth_date")
    LocalDate birth_date;

    @Column(name = "address")
    String address;
    @Column(name = "districtcode")
    String city;
    @Column(name = "wardcode")
    String country;
    @Column(name = "fulladdress")
    String fulladdress;

    @Column(name = "phone")
    String phone;

    @Column(name = "email")
    String email;

    @Column(name = "cccd")
    String cccd;

    @Column(name = "password")
    String password;

    @Column(name = "image")
    String image;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "status")
    int status;
    @Column(name = "actived")
    private boolean actived;
}
