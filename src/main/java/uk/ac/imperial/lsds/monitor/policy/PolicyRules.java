package uk.ac.imperial.lsds.monitor.policy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author mrouaux
 */
public abstract class PolicyRules implements Iterable<PolicyRule> {
    
    private final List<PolicyRule> rules;
    
    protected PolicyRules() {
        rules = new ArrayList<PolicyRule>();
    }
    
    /**
     * 
     * @return 
     */
    protected PolicyRuleBuilder rule() {
        String defaultName = PolicyRule.DEFAULT_POLICY_RULE_NAME 
                                + "-" + rules.size();
        return rule(defaultName);
    }
    
    /**
     * 
     * @param name
     * @return 
     */
    protected PolicyRuleBuilder rule(String name) {
        return new PolicyRuleBuilder(name,
            // Add the built rule to the list of rules
            new PolicyRuleBuilder.PolicyRuleBuilderListener() {
                @Override
                public void onRuleBuilt(PolicyRule builtRule) {
                    rules.add(builtRule);
                }
            });
    }

    @Override
    public Iterator<PolicyRule> iterator() {
        return rules.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(PolicyRule rule : rules) {
            sb.append(rule.toString());
            sb.append(",");
        }
        
        if(sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return "PolicyRules{" 
                    + "rules=" + sb.toString() + '}';
    }
}
