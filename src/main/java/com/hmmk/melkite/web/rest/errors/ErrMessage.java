package com.hmmk.melkite.web.rest.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrMessage {
    private String error;
    private String description;
}
