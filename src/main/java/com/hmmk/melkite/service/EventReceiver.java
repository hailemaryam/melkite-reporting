package com.hmmk.melkite.service;

import com.hmmk.melkite.dao.ChargingDao;
import com.hmmk.melkite.dao.DailySubscriberCounterDao;
import com.hmmk.melkite.dao.PhoneListDao;
import com.hmmk.melkite.dto.SendPayItem;
import com.hmmk.melkite.dto.WebServiceQueueItem;
import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class EventReceiver {

    @Inject
    PhoneListDao phoneListDao;
    @Inject
    DailySubscriberCounterDao dailySubscriberCounterDao;
    @Inject
    ChargingDao chargingDao;

    @Incoming("sdp-notify-reporting")
    @Blocking
    public void sdpNotifyReporting(WebServiceQueueItem webServiceQueueItem) {
        try {
            dailySubscriberCounterDao.createOrUpdate(webServiceQueueItem);
            phoneListDao.createOrUpdate(webServiceQueueItem);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Incoming("success-notifier")
    @Blocking
    public void successNotifier(SendPayItem sendPayItem) {
        try {
            chargingDao.updateSentPayForSuccess(sendPayItem);
            chargingDao.updateSentPayListForSuccess(sendPayItem);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Incoming("fail-notifier")
    @Blocking
    public void failNotifier(SendPayItem sendPayItem) {
        try {
            chargingDao.updateSentPayForFail(sendPayItem);
            chargingDao.updateSentPayListForFail(sendPayItem);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
