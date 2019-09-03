package topologies;

import org.apache.storm.Config;
import org.apache.storm.topology.ConfigurableTopology;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Values;

import java.util.UUID;

public class LambdaTopology extends ConfigurableTopology {
    public static void main(String[] args) {
        ConfigurableTopology.start(new LambdaTopology(), args);
    }

    @Override
    protected int run(String[] args) throws Exception {
        TopologyBuilder builder = new TopologyBuilder();

        String prefix = "Hello lambda:";
        String suffix = ":so cool!";
        int tag = 999;

        builder.setSpout("spout1", () -> UUID.randomUUID().toString());
        builder.setBolt("bolt1", (tuple, collector) -> {
            String[] parts = tuple.getStringByField("lambda").split("\\-");
            collector.emit(new Values(prefix + parts[0] + suffix, tag));
        }, "strValue", "intValue").shuffleGrouping("spout1");
        builder.setBolt("bolt2", System.out::println).shuffleGrouping("bolt1");

        Config conf = new Config();
        conf.setDebug(true);
        conf.setNumWorkers(2);

        return submit("lambda-demo", conf, builder);
    }
}