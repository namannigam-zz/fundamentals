package topologies;

import bolts.AggregatingBolt;
import bolts.FilteringBolt;
import org.apache.storm.Config;
import org.apache.storm.topology.ConfigurableTopology;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.topology.base.BaseWindowedBolt;
import spouts.RandomNumberSpout;

public class FilteringAggregatingTopology extends ConfigurableTopology {

    public static void main(String[] args) throws Exception {
        ConfigurableTopology.start(new FilteringAggregatingTopology(), args);
    }

    @Override
    protected int run(String[] strings) throws Exception {
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("randomNumberSpout", new RandomNumberSpout(), 2);
        builder.setBolt("filteringBolt", new FilteringBolt(), 2)
                .shuffleGrouping("randomNumberSpout");

        builder.setBolt("aggregatingBolt", new AggregatingBolt()
                .withTimestampField("timestamp")
                .withLag(BaseWindowedBolt.Duration.seconds(1))
                .withWindow(BaseWindowedBolt.Duration.seconds(5)), 2)
                .shuffleGrouping("filteringBolt");

        Config config = new Config();
        config.setDebug(false);
        return 0;
    }
}