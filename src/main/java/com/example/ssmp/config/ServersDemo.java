package com.example.ssmp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

//@Configuration
@Data
@ConfigurationProperties(prefix = "servers")
@Validated
public class ServersDemo {
    private String ipAddress;
    @Max(value = 1000 ,message = "端口号过大")
    @Min(value = 100,message = "端口号过小")
    private int port;
    @DurationUnit(ChronoUnit.MINUTES)
    private Duration timeout;
    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize logSize;
}
