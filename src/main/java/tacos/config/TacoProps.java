package tacos.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@ConfigurationProperties(prefix = "taco")
@Component
@Data
@Validated
public class TacoProps {

    @Min(value = 5, message = "must great than 5")
    @Max(value = 20, message = "must less than 20")
    private Integer pageSize;

    private List<String> strList;
}
