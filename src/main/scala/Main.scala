import org.apache.storm.{Config, LocalCluster}
import org.apache.storm.topology.TopologyBuilder

object Main extends App {
  val builder = new TopologyBuilder
  builder.setSpout("spout", new ExampleSpout())
  builder.setBolt("bolt", new ExampleBolt()) shuffleGrouping "spout"

  val conf = new Config
  val cluster = new LocalCluster

  try {
    cluster.submitTopology("Example", conf, builder.createTopology())
    Thread sleep 10000
  } finally {
    cluster.shutdown()
  }
}
