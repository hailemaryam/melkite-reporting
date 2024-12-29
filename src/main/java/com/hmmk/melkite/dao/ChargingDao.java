package com.hmmk.melkite.dao;

import com.hmmk.melkite.dto.SendPayItem;
import com.hmmk.melkite.entity.charging.SentPay;
import com.hmmk.melkite.entity.charging.SentPayList;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ChargingDao {
    public void updateSentPayForSuccess(SendPayItem sendPayItem){
        SentPay sentPay = SentPay.findById(sendPayItem.getSentPayId());
        sentPay.successfulCount = sentPay.successfulCount + 1;
        sentPay.persistAndFlush();
    }
    public void updateSentPayListForSuccess(SendPayItem sendPayItem){
        SentPayList sendPayList = SentPayList.findById(sendPayItem.getSendPayListId());
        sendPayList.successfulCount = 1;
        sendPayList.noBalanceCount = sendPayItem.getNoBalanceCount();
        sendPayList.internalErrorCount = sendPayItem.getInternalErrorCount();
        sendPayList.noSubscriptionCount = sendPayItem.getNoSubscriptionCount();
        sendPayList.hourRetryLimitExceededCount = sendPayItem.getHourRetryLimitExceededCount();
        sendPayList.dayRetryLimitExceededCount = sendPayItem.getDayRetryLimitExceededCount();
        sendPayList.invalidRenewalPeriodCount = sendPayItem.getInvalidRenewalPeriodCount();
        sendPayList.invalidSubscriberStatusCount = sendPayItem.getInvalidSubscriberStatusCount();
        sendPayList.userNotEligibleCount = sendPayItem.getUserNotEligibleCount();
        sendPayList.unknownErrorCount = sendPayItem.getUnknownErrorCount();
        sendPayList.totalNoOfRequestSent = sendPayItem.getTotalNoOfRequestSent();
        sendPayList.persistAndFlush();
    }
    public void updateSentPayForFail(SendPayItem sendPayItem){
        SentPay sentPay = SentPay.findById(sendPayItem.getSentPayId());
        sentPay.failedCount = sentPay.failedCount + 1;
        sentPay.persistAndFlush();
    }
    public void updateSentPayListForFail(SendPayItem sendPayItem){
        SentPayList sendPayList = SentPayList.findById(sendPayItem.getSendPayListId());
        sendPayList.successfulCount = 0;
        sendPayList.noBalanceCount = sendPayItem.getNoBalanceCount();
        sendPayList.internalErrorCount = sendPayItem.getInternalErrorCount();
        sendPayList.noSubscriptionCount = sendPayItem.getNoSubscriptionCount();
        sendPayList.hourRetryLimitExceededCount = sendPayItem.getHourRetryLimitExceededCount();
        sendPayList.dayRetryLimitExceededCount = sendPayItem.getDayRetryLimitExceededCount();
        sendPayList.userNotEligibleCount = sendPayItem.getUserNotEligibleCount();
        sendPayList.unknownErrorCount = sendPayItem.getUnknownErrorCount();
        sendPayList.invalidRenewalPeriodCount = sendPayItem.getInvalidRenewalPeriodCount();
        sendPayList.invalidSubscriberStatusCount = sendPayItem.getInvalidSubscriberStatusCount();
        sendPayList.totalNoOfRequestSent = sendPayItem.getTotalNoOfRequestSent();
        sendPayList.persistAndFlush();
    }
}
