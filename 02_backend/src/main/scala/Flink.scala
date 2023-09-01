import java.net.{InetAddress, InetSocketAddress, Socket, StandardProtocolFamily}
import java.nio.channels.SocketChannel

class Flink(val address: String, val port: Int) {
	val host: InetAddress = InetAddress.getByName(address)
	val channel: SocketChannel = java.nio.channels.SocketChannel.open(StandardProtocolFamily.INET)
	val socket: Socket = channel.socket()
	channel.configureBlocking(false)
	socket.bind(new InetSocketAddress(host, port))
}
