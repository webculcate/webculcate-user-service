package com.webculcate.userservice.core.service.UserServiceManager;

import com.webculcate.userservice.core.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.webculcate.userservice.core.constant.ServiceConstant.PROXY_ENABLED;
import static com.webculcate.userservice.core.constant.UserServiceStrategyType.DEFAULT_SERVICE;
import static com.webculcate.userservice.core.constant.UserServiceStrategyType.PROXY;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceManager {

    private final Map<String, IUserService> serviceMap;

    @Value(PROXY_ENABLED)
    private boolean proxyEnabled;

    public IUserService getUserService() {
        if (proxyEnabled)
            return serviceMap.get(PROXY);
        else
            return serviceMap.get(DEFAULT_SERVICE);
    }
}
