package com.softblue.bluefood.domain.usuario;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public class Usuario implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O Nome não pode ser vazio")
    @Size(max = 80, message = "O Nome é muito grande")
    private String nome;

    @NotBlank(message = "O E-mail não pode ser vazio")
    @Size(max = 60, message = "O E-mail é muito grande")
    @Email(message = "O E-mail é inválido")
    private String email;

    @NotBlank(message = "A Senha não pode ser vazio")
    @Size(max = 80, message = "A Senha é muito grande")
    private String senha;

    @NotBlank(message = "O Telefone não pode ser vazio")
    @Pattern(regexp = "[0-9]{10,11}")
    @Column(length = 11, nullable = false)
    private String telefone;
}
