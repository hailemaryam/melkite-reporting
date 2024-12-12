package com.hmmk.melkite.dao;

import com.hmmk.melkite.dto.SendPayItem;
import com.hmmk.melkite.entity.charging.SentPay;
import com.hmmk.melkite.entity.charging.SentPayList;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ChargingDao {
    public SentPay findSentPayByServiceIdProductIdCustomerSegmentGroupAndAtDateOf(String serviceId, String productId, String customerSegmentGroup, String atDateOf){
        return SentPay.find("serviceId = ?1 and productId = ?2 and customerSegmentGroup = ?3 and atDateOf = ?4", serviceId, productId, customerSegmentGroup, atDateOf).firstResult();
    }
    public SentPayList findSentPayListByServiceIdProductIdSentPayIdAndPhone(String serviceId, String productId, String sentPayId, String phone){
        return SentPayList.find("serviceId = ?1 and productId = ?2 and sentPayId = ?3 and phone = ?4", serviceId, productId, sentPayId, phone).firstResult();
    }
    public void updateSentPayForSuccess(SendPayItem sendPayItem){
        SentPay sentPay = findSentPayByServiceIdProductIdCustomerSegmentGroupAndAtDateOf(sendPayItem.getServiceId(), sendPayItem.getProductId(), sendPayItem.getCustomerSegmentGroup(), sendPayItem.getAtDateOf());
        sentPay.successfulCount = sentPay.successfulCount + 1;
        sentPay.persistAndFlush();
    }
    public void updateSentPayListForSuccess(SendPayItem sendPayItem){
        SentPayList sendPayList = findSentPayListByServiceIdProductIdSentPayIdAndPhone(sendPayItem.getServiceId(), sendPayItem.getProductId(), sendPayItem.getId(), sendPayItem.getPhone());
        sendPayList.successfulCount = 1;
        sendPayList.noBalanceCount = sendPayItem.getNoBalanceCount();
        sendPayList.invalidSubscriptionCount = sendPayItem.getInvalidSubscriptionCount();
        sendPayList.internalErrorCount = sendPayItem.getInternalErrorCount();
        sendPayList.noSubscriptionCount = sendPayItem.getNoSubscriptionCount();
        sendPayList.hourRetryLimitExceededCount = sendPayItem.getHourRetryLimitExceededCount();
        sendPayList.dayRetryLimitExceededCount = sendPayItem.getDayRetryLimitExceededCount();
        sendPayList.totalNoOfRequestSent = sendPayItem.getTotalNoOfRequestSent();
        sendPayList.persistAndFlush();
    }
    public void updateSentPayForFail(SendPayItem sendPayItem){
        SentPay sentPay = findSentPayByServiceIdProductIdCustomerSegmentGroupAndAtDateOf(sendPayItem.getServiceId(), sendPayItem.getProductId(), sendPayItem.getCustomerSegmentGroup(), sendPayItem.getAtDateOf());
        sentPay.failedCount = sentPay.failedCount + 1;
        sentPay.persistAndFlush();
    }
    public void updateSentPayListForFail(SendPayItem sendPayItem){
        SentPayList sendPayList = findSentPayListByServiceIdProductIdSentPayIdAndPhone(sendPayItem.getServiceId(), sendPayItem.getProductId(), sendPayItem.getId(), sendPayItem.getPhone());
        sendPayList.successfulCount = 0;
        sendPayList.noBalanceCount = sendPayItem.getNoBalanceCount();
        sendPayList.invalidSubscriptionCount = sendPayItem.getInvalidSubscriptionCount();
        sendPayList.internalErrorCount = sendPayItem.getInternalErrorCount();
        sendPayList.noSubscriptionCount = sendPayItem.getNoSubscriptionCount();
        sendPayList.hourRetryLimitExceededCount = sendPayItem.getHourRetryLimitExceededCount();
        sendPayList.dayRetryLimitExceededCount = sendPayItem.getDayRetryLimitExceededCount();
        sendPayList.totalNoOfRequestSent = sendPayItem.getTotalNoOfRequestSent();
        sendPayList.persistAndFlush();
    }
}
