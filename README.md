Framework for Dynamic Scaling in Master-Slave Stream Processing Systems
=======================================================================

This is a generic Java framework to support dynamic auto-scaling in Stream Processing Systems architected following a master-slave paradigm. The framework is based on an abstract model for scaling policies, which can be specified using an embedded domain-specific language as shown below:

```java
PolicyRules rules = new PolicyRules() {{ 
  
  rule("CPU utilisation is above 50% for 5 minutes")
    .scaleOut(operator("SimpleOperator", OP_ID))
    .by(relative(2)).butNeverAbove(nodes(32))
    .when(metric("cpu"))
    .is(above(percent(50)))
    .forAtLeast(minutes(5)).build();

  rule("CPU utilisation is below 25% for 10 minutes")
    .scaleIn(operator("SimpleOperator", OP_ID))
    .by(relative(2)).butNeverBelow(nodes(1))
    .when(metric("cpu"))
    .is(below(percent(25)))
    .forAtLeast(minutes(10)).build();
}};
```

The framework can be built easily using Maven (see http://maven.apache.org/ for more details). Executing the target _install_ will build the framework and run a set of unit and integration tests that validate the functional correctness of the system.

This work was completed as part of the MSc Degree in Computing for Industry course at Imperial College London.
