package com.saturnPulse.SaturnPulse.Exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Builder
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminExceptionCode {

    private Integer errorCode;

    private List<String> message;

    private HttpStatus httpStatus;

    private Timestamp timestamp;
}
