package com.yairo.helloworld.metrics.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class DogDeletedMetricEvent extends MetricEvent {
    private final int metricId = 2;
    private long id;
}
