package uk.ac.imperial.lsds.monitor.policy.scale.factor;

import uk.ac.imperial.lsds.monitor.policy.action.Action;
import uk.ac.imperial.lsds.monitor.policy.action.ScaleInAction;

/**
 * Absolute scaling factor for a policy rule. This class represents an absolute 
 * increase in the number of physical nodes/VMs allocated to a particular operator.
 * E.g.: if the factor is 4 and the current size is 6, then the new operator size 
 * after applying the scaling factor will be 10.
 * 
 * @author mrouaux
 */
public class AbsoluteScaleFactor extends ScaleFactor {

    /**
     * Convenience constructor.
     * @param factor Scaling factor
     */
    AbsoluteScaleFactor(int factor) {
        super(factor);
    }

    /**
     * Applies the absolute scaling factor by adding the scaling factor to the 
     * current operator size.
     * 
     * @param currentSize Current number of machines allocated.
     * @param action Action indicating how the scaling factor needs to be applied
     * (increase or reduce the current size by the scaling factor).
     * @return Scaled number of machines to allocate.
     */    
    @Override
    public int apply(int currentSize, Action action) {
        // Assume a scale-out action
        int newSize = currentSize + (new Double(getFactor())).intValue();
        
        if(action instanceof ScaleInAction) {
            newSize = currentSize - (new Double(getFactor())).intValue();
            
            if(newSize < 1) {
                newSize = 1;
            }
        }
        
        return newSize;
    }
}
