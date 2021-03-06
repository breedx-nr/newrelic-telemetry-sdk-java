/*
 * Copyright 2019 New Relic Corporation. All rights reserved.
 * SPDX-License-Identifier: Apache-2.0
 */
package com.newrelic.telemetry.metrics;

import com.newrelic.telemetry.Attributes;
import com.newrelic.telemetry.TelemetryBatch;
import java.util.Collection;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/** Represents a set of {@link Metric} instances, to be sent up to the New Relic Metrics API. */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MetricBatch extends TelemetryBatch<Metric> {

  public MetricBatch(Collection<Metric> metrics, Attributes commonAttributes) {
    super(metrics, commonAttributes);
  }

  @Override
  public TelemetryBatch<Metric> createSubBatch(Collection<Metric> telemetry) {
    return new MetricBatch(telemetry, getCommonAttributes());
  }
}
