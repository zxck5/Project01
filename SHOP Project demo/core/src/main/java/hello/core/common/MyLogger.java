package hello.core.common;


import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
// client's request, bean is created and destroyed when the request is finished.
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Setter
@Getter
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void log(String message) {
        System.out.println("[" + uuid + "]" + " [" + requestURL + "] " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("["+uuid+"] request scope has been created: " + this);

    }

    @PreDestroy
    public void destroy() {
        System.out.println("["+uuid+"] request scope has been created: " + this);
    }
}
