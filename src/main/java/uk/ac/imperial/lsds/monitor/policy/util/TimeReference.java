package uk.ac.imperial.lsds.monitor.policy.util;

import org.joda.time.Instant;

/**
 * Interface for classes providing a time reference for rule evaluation.
 * 
 * @author mrouaux
 */
public interface TimeReference {

    Instant now();
    
}
