package com.hmmk.melkite.scheduled;

import com.hmmk.melkite.dao.CustomerSegmentGroupDao;
import com.hmmk.melkite.dao.PhoneListDao;
import com.hmmk.melkite.dto.SendPayItem;
import com.hmmk.melkite.entity.charging.SentPay;
import com.hmmk.melkite.entity.charging.SentPayList;
import com.hmmk.melkite.entity.company.CompanyDetail;
import com.hmmk.melkite.entity.subscription.CustomerSegmentGroup;
import com.hmmk.melkite.entity.subscription.PhoneList;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class PublishNewDayCharging {
    @Inject
    CustomerSegmentGroupDao customerSegmentGroupDao;

    @Inject
    @Channel("chargeable-item")
    Emitter<SendPayItem> chargeableItem;

    @Inject
    PhoneListDao phoneListDao;

    @Scheduled(cron = "0 0 0 * * ?")
    public void publishNewDayCharging() throws InterruptedException {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);

        List<CompanyDetail> allCompany = CompanyDetail.listAll();
        for (CompanyDetail companyDetail : allCompany) {
            List<CustomerSegmentGroup> allCustomerSegmentByServiceIdAndProductId = customerSegmentGroupDao.findAllByServiceIdAndProductId(companyDetail.serviceId, companyDetail.productId);
            for (CustomerSegmentGroup customerSegmentGroup : allCustomerSegmentByServiceIdAndProductId) {
                executorService.submit(() -> {
                    createAndSentToQueue(companyDetail, customerSegmentGroup);
                });
            }
        }
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }

    private void createAndSentToQueue(CompanyDetail companyDetail, CustomerSegmentGroup customerSegmentGroup) {
        SentPay sentPay = createSentPay(companyDetail, customerSegmentGroup);
        List<PhoneList> phoneLists = phoneListDao.findByCustomerSegmentGroup(customerSegmentGroup.id);
        for (PhoneList phoneList : phoneLists) {
            SentPayList sentPayList = createSentPayList(phoneList, sentPay, companyDetail);
            SendPayItem sendPayItem = convertToSentPayItem(sentPayList);
            chargeableItem.send(sendPayItem);
        }
    }

    SendPayItem convertToSentPayItem(SentPayList sentPayList){
        SendPayItem sendPayItem = new SendPayItem();
        sendPayItem.setId(sentPayList.id);
        sendPayItem.setAtDateOf(Instant.now().truncatedTo(ChronoUnit.DAYS).toString());
        sendPayItem.setSpId(sentPayList.spId);
        sendPayItem.setHash(sentPayList.hash);
        sendPayItem.setServiceId(sentPayList.serviceId);
        sendPayItem.setProductId(sentPayList.productId);
        sendPayItem.setPhone(sentPayList.phone);
        sendPayItem.setCustomerSegmentGroup(sentPayList.customerSegmentGroup);
        sendPayItem.setSentPayId(sentPayList.sentPayId);
        sendPayItem.setSendPayListId(sentPayList.id);
        sendPayItem.setStatus(false);
        return sendPayItem;
    }

    SentPayList createSentPayList(PhoneList phoneList, SentPay sentPay, CompanyDetail companyDetail){
        SentPayList sentPayList = new SentPayList();
        sentPayList.serviceId = phoneList.serviceId;
        sentPayList.productId = phoneList.productId;
        sentPayList.spId = companyDetail.spId;
        sentPayList.hash = companyDetail.hash;
        sentPayList.sentPayId = sentPay.id;
        sentPayList.customerSegmentGroup = phoneList.customerSegmentGroup;
        sentPayList.phone = phoneList.phone;
        sentPayList.persist();
        return sentPayList;
    }

    SentPay createSentPay(CompanyDetail companyDetail, CustomerSegmentGroup customerSegmentGroup){
        SentPay sentPay = new SentPay();
        sentPay.atDateOf = Instant.now().truncatedTo(ChronoUnit.DAYS).toString();
        sentPay.serviceId = companyDetail.serviceId;
        sentPay.productId = companyDetail.productId;
        sentPay.customerSegmentGroup = customerSegmentGroup.id;
        sentPay.sentTime = Instant.now();
        sentPay.expiryTime = Instant.now().truncatedTo(ChronoUnit.DAYS).plus(1, ChronoUnit.DAYS).minus(1, ChronoUnit.SECONDS);
        sentPay.persist();
        return sentPay;
    }

}
