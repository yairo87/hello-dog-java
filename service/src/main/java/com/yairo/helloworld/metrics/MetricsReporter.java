package com.yairo.helloworld.metrics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yairo.helloworld.metrics.events.MetricEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MetricsReporter {

    private final ObjectMapper mapper;

    @Autowired
    public MetricsReporter(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public void sendMetricEvent(MetricEvent event){
        try {
            log.info("METRIC_EVENT {}", mapper.writeValueAsString(event));
        } catch (JsonProcessingException e) {
            log.error("failed sending metric event", e);
        }
    }

}
