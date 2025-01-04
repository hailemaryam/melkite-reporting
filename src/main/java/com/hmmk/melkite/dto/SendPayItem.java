package com.hmmk.melkite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendPayItem {
    private Long id;
    private String atDateOf;
    private String spId;
    private String hash;
    private String serviceId;
    private String productId;
    private String phone;
    private Long customerSegmentGroup;
    private Long sentPayId;
    private Long sendPayListId;
    private Boolean status;
    private String statusMessage;
    private Instant lastSentTime;
    private int noBalanceCount;
    private int invalidRenewalPeriodCount;
    private int invalidSubscriberStatusCount;
    private int internalErrorCount;
    private int noSubscriptionCount;
    private int hourRetryLimitExceededCount;
    private int dayRetryLimitExceededCount;
    private int userNotEligibleCount;
    private int unknownErrorCount;
    private int totalNoOfRequestSent;
}
