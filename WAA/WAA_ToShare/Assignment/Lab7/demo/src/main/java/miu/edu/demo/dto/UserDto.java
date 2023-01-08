package miu.edu.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miu.edu.demo.domain.Role;
import miu.edu.demo.domain.User;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    long id;
    String name;
    String username;
    boolean isEnabled;

    private Set<Role> roles;
}
