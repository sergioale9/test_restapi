package test_restapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
}
