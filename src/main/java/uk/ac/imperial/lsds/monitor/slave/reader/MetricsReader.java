package uk.ac.imperial.lsds.monitor.slave.reader;

import java.util.List;
import uk.ac.imperial.lsds.monitor.policy.metric.MetricName;
import uk.ac.imperial.lsds.monitor.policy.metric.MetricValue;

/**
 * Base interface for all metric readers supported by the system. At the very least,
 * a reader should be capable of returning values for a given metric and also, 
 * indicate the names of all the metrics it supports.
 * 
 * @author mrouaux
 */
public interface MetricsReader {
    
    List<MetricName> readableNames();
    
    MetricValue readValue(MetricName name);
    
}
