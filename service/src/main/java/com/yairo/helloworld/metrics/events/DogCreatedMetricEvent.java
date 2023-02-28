package com.yairo.helloworld.metrics.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class DogCreatedMetricEvent extends MetricEvent {
    private final int metricId = 1;
    private String id;
    private String name;
}
