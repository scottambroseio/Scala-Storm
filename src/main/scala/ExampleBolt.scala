import org.apache.storm.topology.{BasicOutputCollector, OutputFieldsDeclarer}
import org.apache.storm.topology.base.BaseBasicBolt
import org.apache.storm.tuple.{Tuple}

class ExampleBolt extends BaseBasicBolt{
  override def execute(input: Tuple, collector: BasicOutputCollector): Unit = println(input.getInteger(0))

  override def declareOutputFields(declarer: OutputFieldsDeclarer): Unit = {}
}
