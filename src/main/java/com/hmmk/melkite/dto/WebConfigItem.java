package com.hmmk.melkite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebConfigItem {
    private String id;
    private String serviceId;
    private String productId;
    private String webUrlRegister;
    private String webQueryParamRegister;
    private String webMethodRegister;
    private String webPayloadRegister;
    private String webUrlDelete;
    private String webQueryParamDelete;
    private String webMethodDelete;
    private String webPayloadDelete;
    private String webUrlNoticeCharging;
    private String webQueryParamNoticeCharging;
    private String webMethodNoticeCharging;
    private String webPayloadNoticeCharging;
    private String webHeaderName;
    private String webHeaderValue;
    private Date dateCreated;
    private Date dateUpdated;
}
