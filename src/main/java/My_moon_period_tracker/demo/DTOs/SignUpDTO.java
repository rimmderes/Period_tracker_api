package My_moon_period_tracker.demo.DTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SignUpDTO {
    private String name;
    private String password;
    private String email;
    private LocalDate DOB;
}
