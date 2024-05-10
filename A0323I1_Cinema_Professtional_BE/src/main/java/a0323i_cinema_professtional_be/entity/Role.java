package a0323i_cinema_professtional_be.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Table(name = "role")
public enum Role {
    ADMIN, USER
}
