package edu.fundamental.application;

import com.codahale.metrics.health.HealthCheck;

public class CalendarHealthCheck extends HealthCheck {
    @Override
    protected Result check() {
        return Result.healthy();
    }
}
