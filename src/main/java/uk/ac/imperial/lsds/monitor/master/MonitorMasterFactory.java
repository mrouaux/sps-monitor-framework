package uk.ac.imperial.lsds.monitor.master;

import uk.ac.imperial.lsds.monitor.Factory;
import uk.ac.imperial.lsds.monitor.policy.PolicyRules;
import uk.ac.imperial.lsds.monitor.policy.util.Infrastructure;
import uk.ac.imperial.lsds.monitor.policy.util.InfrastructureAdaptor;

/**
 * Factory class for MonitorMaster objects.
 * @author mrouaux
 */
public abstract class MonitorMasterFactory implements Factory<MonitorMaster> {

    private Infrastructure infrastructure;
    private PolicyRules rules;
    private int masterPort;

    /**
     * Convenience constructor.
     * @param infrastructure Underlying infrastructure over which to apply scaling 
     * decisions.
     * @param rules Scaling rules that control scaling for the current query.
     * @param monitorMasterPort TCP port on which to listen for incoming slave 
     * connections.
     */
    public MonitorMasterFactory(final Infrastructure infrastructure, 
                final PolicyRules rules) {
        
        this.infrastructure = infrastructure;
        this.rules = rules;
        
        this.masterPort = Integer.valueOf(System.getProperty("monitorManagerPort"));
    }
    
    /**
     * Creates and initialises a MonitorMaster instance.
     * @return MonitorMaster instance.
     */
    @Override
    public MonitorMaster create() {
        InfrastructureAdaptor adaptor = createInfrastructureAdaptor(infrastructure);
        return new MonitorMaster(adaptor, rules, masterPort);
    }

    @Override
    public MonitorMaster create(Object... args) {
        return create();
    }
    
    protected abstract InfrastructureAdaptor createInfrastructureAdaptor(
                                            final Infrastructure infrastructure);
}
