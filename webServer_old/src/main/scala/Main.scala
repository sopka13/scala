import java.io.{BufferedReader, BufferedWriter, InputStreamReader, OutputStreamWriter}
import java.net.{InetAddress, ServerSocket}
import scala.collection.mutable.ArrayBuffer
import scala.ref.ReferenceQueue

/*
	This is agent for get/exec/forwarding messages
	RUN:
		svs_agent
		svs_agent <config_file_path>


	Work targets:
	1. Add miltiplex i/o for sockets
	2. Add config file and parsing it
 */

import java.net.Socket

object Main {
	def main(args: Array[String]): Unit = {
		// Handle args
		if (args.length < 4)
		// Parsing config file
		// Create epoll
		// Create sockets and add in queue

		// Create socket
		val ipAddress: InetAddress = InetAddress.getByName("127.0.0.1")
		val port = 1111
		val queueLength = 100
		val server = new ServerSocket(port, queueLength, ipAddress)

		// Create client connections
		val client = server.accept()

		// Create input and output buffer
		val in = new BufferedReader(new InputStreamReader(client.getInputStream))
		val out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream))

		// Read request
		val message = new ArrayBuffer[String]
		message.addOne(in.readLine())
		while (message.apply(message.length - 1).nonEmpty) {
			message.addOne(in.readLine())
//			println(message.mkString("\n") + "| = " + message.apply(if (message.length > 0) message.length - 1 else 0).length)
		}
		println(s"Get message: ${message.mkString("\n")}")

		// Send responce
		println("fine")
		out.write("HTTP/1.1 200 OK\n\n")
		out.flush()
		println("fine 2")

		client.close()
		println("fine 3")
		in.close()
		println("fine 4")
		out.close()
		println("fine 5")
		// Cycle for monitoring connections on sockets
//		while (true) {
//			println(s"Cycle iteration")
//			wait(100)
//		}
	}
}
