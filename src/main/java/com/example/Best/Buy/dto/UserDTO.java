
import com.example.Best.Buy.domain.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
//    @NotBlank(message = "name should not be blank")
    private String name;
//    @NotBlank(message = "email should not be blank")
    private String email;
//    @NotNull(message = "createdAt should not be blank")
    private LocalDate createdAt;


    private Cart cart;
}
