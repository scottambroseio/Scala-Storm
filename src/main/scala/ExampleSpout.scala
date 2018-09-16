import java.util

import org.apache.storm.spout.SpoutOutputCollector
import org.apache.storm.task.TopologyContext
import org.apache.storm.topology.OutputFieldsDeclarer
import org.apache.storm.topology.base.BaseRichSpout
import org.apache.storm.tuple.{Fields, Values}

import scala.util.Random

class ExampleSpout extends BaseRichSpout {
  var _collector: SpoutOutputCollector = _

  override def declareOutputFields(declarer: OutputFieldsDeclarer): Unit = declarer.declare(new Fields("Number"))

  override def open(conf: util.Map[_, _], context: TopologyContext, collector: SpoutOutputCollector): Unit = _collector = collector

  override def nextTuple(): Unit = {
    _collector.emit(new Values(Random.nextInt(100).asInstanceOf[Object]))
  }
}
