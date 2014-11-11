/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.imperial.lsds.monitor.policy.threshold;

import uk.ac.imperial.lsds.monitor.policy.metric.MetricValue;

/**
 *
 * @author mrouaux
 */
public class MetricThresholdAbove extends MetricThreshold {
    
    MetricThresholdAbove(MetricValue threshold) {
        super(threshold);
    }
    
    @Override
    public boolean evaluate(MetricValue value) {
        return value.convertTo(getThreshold().getUnit()).getValue() > getThreshold().getValue();
    }
}
