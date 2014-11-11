/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.imperial.lsds.monitor.policy.syntax;

import uk.ac.imperial.lsds.monitor.policy.metric.MetricName;

/**
 *
 * @author martinrouaux
 */
public interface MetricSyntax {
    
    MetricSyntax when(MetricName metricName);

    MetricSyntax and(MetricName metricName);
    
}
