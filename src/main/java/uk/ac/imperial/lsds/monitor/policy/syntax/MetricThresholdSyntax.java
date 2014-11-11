/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.imperial.lsds.monitor.policy.syntax;

import uk.ac.imperial.lsds.monitor.policy.threshold.MetricThreshold;

/**
 *
 * @author martinrouaux
 */
public interface MetricThresholdSyntax {
    
    MetricThresholdSyntax is(MetricThreshold metricThreshold);

}
