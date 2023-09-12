package com.iohim.shopbook.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Ошибка имя не должно быть пустым")
    @Size(min = 3, max = 40, message = "ошибка не верное количиство сиволов")
    @Column(name= "name")
    private String name;

    @NotEmpty(message = "Ошибка фамилия не должна быть пустой")
    @Size(min = 1, max = 40, message = "ошибка не верное количиство сиволов")
    @Column(name= "lastName")
    private String lastName;

    @NotEmpty(message = "Ошибка отчество не должно быть пустым")
    @Size(min = 1, max = 40, message = "ошибка не верное количиство сиволов")
    @Column(name= "patronymic")
    private String patronymic;

    @Min(value = 1, message = "Возрост не может быть нулевым")
    @Column(name= "age")
    private Long age;

    @NotEmpty(message = "Ошибка Email не может быть пустым")
    @Email
    @Column(name= "email")
    private String email;

}
