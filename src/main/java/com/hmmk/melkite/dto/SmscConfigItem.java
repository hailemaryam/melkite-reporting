package com.hmmk.melkite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmscConfigItem {
    private String id;
    private String serviceId;
    private String productId;
    private String username;
    private String password;
    private String ip;
    private String port;
    private String shortCode; // will be used as smsc-id
    private String okReplyTemplate;
    private String language;
    private Date dateCreated;
    private Date dateUpdated;

}
