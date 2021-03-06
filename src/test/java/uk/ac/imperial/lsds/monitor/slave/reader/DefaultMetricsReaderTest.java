package uk.ac.imperial.lsds.monitor.slave.reader;

import uk.ac.imperial.lsds.monitor.slave.reader.DefaultMetricsReader;
import java.util.List;
import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uk.ac.imperial.lsds.monitor.policy.metric.MetricName;
import uk.ac.imperial.lsds.monitor.policy.metric.MetricUnit;
import uk.ac.imperial.lsds.monitor.policy.metric.MetricValue;

/**
 *
 * @author mrouaux
 */
public class DefaultMetricsReaderTest {

    public DefaultMetricsReaderTest() {
    }
   
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testGetReadableNames() {
        System.out.println("testGetReadableNames");
        
        DefaultMetricsReader reader = new DefaultMetricsReader();
        
        List<MetricName> names = reader.readableNames();
        assertThat(names, containsInAnyOrder(
                MetricName.CPU_UTILIZATION,
                MetricName.HEAP_SIZE,
                MetricName.HEAP_UTILIZATION,
                MetricName.OPERATOR_LATENCY,
                MetricName.QUEUE_LENGTH));
    }
    
    @Test
    public void testReadCpuUtilization() {
        System.out.println("testReadCpuUtilization");
        
        DefaultMetricsReader reader = new DefaultMetricsReader();
        MetricValue value = reader.readValue(MetricName.CPU_UTILIZATION);
        
        assertThat(value, notNullValue());
        assertThat(value.getUnit(), equalTo(MetricUnit.PERCENT));
        assertThat(value.getValue(), greaterThanOrEqualTo(0.0));
        assertThat(value.getValue(), lessThanOrEqualTo(100.0));
    }
    
    @Test
    public void testReadHeapSize() {
        System.out.println("testReadHeapSize");
        
        DefaultMetricsReader reader = new DefaultMetricsReader();
        MetricValue value = reader.readValue(MetricName.HEAP_SIZE);
        
        assertThat(value, notNullValue());
        assertThat(value.getUnit(), equalTo(MetricUnit.BYTES));
        assertThat(value.getValue(), greaterThanOrEqualTo(0.0));
    }
    
    @Test
    public void testReadHeapUtilization() {
        System.out.println("testReadHeapUtilization");
        
        DefaultMetricsReader reader = new DefaultMetricsReader();
        MetricValue value = reader.readValue(MetricName.HEAP_UTILIZATION);
        
        assertThat(value, notNullValue());
        assertThat(value.getUnit(), equalTo(MetricUnit.PERCENT));
        assertThat(value.getValue(), greaterThanOrEqualTo(0.0));
        assertThat(value.getValue(), lessThanOrEqualTo(100.0));
    }
    
    @Test
    public void testReadOperatorLatency() {
        System.out.println("testReadOperatorLatency");
        
        DefaultMetricsReader reader = new DefaultMetricsReader();
        MetricValue value = reader.readValue(MetricName.OPERATOR_LATENCY);
        
        assertThat(value, notNullValue());
        assertThat(value.getUnit(), equalTo(MetricUnit.MILLISECONDS));
        assertThat(value.getValue(), greaterThanOrEqualTo(0.0));
    }
    
    
    @Test
    public void testReadQueueLength() {
        System.out.println("testReadQueueLength");
        
        DefaultMetricsReader reader = new DefaultMetricsReader();
        MetricValue value = reader.readValue(MetricName.QUEUE_LENGTH);
        
        assertThat(value, notNullValue());
        assertThat(value.getUnit(), equalTo(MetricUnit.TUPLES));
        assertThat(value.getValue(), greaterThanOrEqualTo(0.0));
    }
}
