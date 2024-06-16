package com.example.subscriber_bc.service.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
public class SubscriberApiError {
    private String field;
    private String value;
    private String message;
}
