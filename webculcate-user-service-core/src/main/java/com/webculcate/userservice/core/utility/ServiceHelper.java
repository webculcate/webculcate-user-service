package com.webculcate.userservice.core.utility;

import com.webculcate.userservice.core.model.entity.embedded.TimeLog;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.function.Supplier;

@Slf4j
@UtilityClass
public class ServiceHelper {

    public static <T> Optional<T> nullHandledExtraction(Supplier<T> methodChain) {
        try {
            return Optional.ofNullable(methodChain.get());
        } catch (NullPointerException exception) {
            log.error("Exception : ", exception);
            return Optional.empty();
        }
    }

    public static TimeLog createTimeLog() {
        long currentTime = System.currentTimeMillis();
        return new TimeLog(currentTime, currentTime);
    }

}
