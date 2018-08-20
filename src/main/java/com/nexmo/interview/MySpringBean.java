package com.nexmo.interview;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MySpringBean {

    @Cacheable
    public Object reallyExpensiveOperation(){
        return "result";
    }

    @Cacheable
    Object someOtherExpensiveOperation(){
        return "result";
    }
}
