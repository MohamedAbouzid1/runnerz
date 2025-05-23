package dev.mohamed.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

public record Run(

                Integer id,
                @NotEmpty
                String title,
                LocalDateTime startedOn,
                LocalDateTime completedOn,
                @Positive
                Integer miles,
                Location location,
                @Version
                Integer version

) {
}