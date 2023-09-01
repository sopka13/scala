import java.net.{InetAddress, InetSocketAddress, ProtocolFamily, ServerSocket, Socket, StandardProtocolFamily}
import java.nio.channels.{SelectionKey, Selector, ServerSocketChannel}

object Temp {
	def main(args: Array[String]): Unit = {
		// Create input socket
		val ipFront: InetAddress = InetAddress.getByName("127.0.0.1")
		val portFront: Int = 12345
//		val queueLengthFront: Int = 100
//		val socketFront = new ServerSocket(portFront, queueLengthFront, ipFront)
		val chanelFront = ServerSocketChannel.open(StandardProtocolFamily.INET) // create channel
		val socketFront = chanelFront.socket()
		socketFront.bind(new InetSocketAddress(ipFront, portFront))
		chanelFront.configureBlocking(false) // set nonblock

		// Create flink socket
		val ipFlink: InetAddress = InetAddress.getByName("127.0.0.1")
		val portFlink: Int = 8081
//		val socketFlink = new Socket(ipFlink, portFlink)
		val chanelFlink = java.nio.channels.SocketChannel.open(StandardProtocolFamily.INET)
		val socketFlink = chanelFlink.socket()
		chanelFlink.configureBlocking(false)
		socketFlink.bind(new InetSocketAddress(ipFlink, portFlink))

		// Create select
		val selector = Selector.open

		// Add all fd in queue
		chanelFront.register(selector, SelectionKey.OP_ACCEPT) // add front in queue
		chanelFlink.register(selector, SelectionKey.OP_WRITE)
//		selector.keys().remove(frontChanel) // rm front in queue

		// Start monitoring
		while (true){
			if (selector.select() > 0) { // blocking wait
//			if (selector.select(SelectionKey.OP_CONNECT) > 0) { // waiting specific action
				val it = selector.selectedKeys().iterator()

				// Get request from front
				// Handle this request
				// Send request for flink
				// Get response from flink
				// Handle this response
				// Send response to front
				// Add fd in queue
			}
		}
	}
}
