import scala.io.Source

class Vars(val flinks: Array[Flink]) {
}

object Vars{
	def getFlinkHosts: Vars = {
		val url = getClass.getClassLoader.getResource("flink_hosts.txt").toURI
		val source = Source.fromFile(url)
		new Vars((for(str <- source.getLines()) yield new
				Flink(str.trim.split(':').apply(0), str.trim.split(':').apply(1).toInt)).toArray)
	}
}
