import java.io.{BufferedReader, BufferedWriter, DataInputStream, DataOutputStream, InputStreamReader, OutputStreamWriter}
import java.lang.ref.ReferenceQueue
import java.net.{InetAddress, ServerSocket, Socket}
import scala.collection.mutable.ArrayBuffer
import scala.ref.ReferenceQueue

// Backend
// 1. Create input socket
// 2. Create client socket for flink hosts
// 3. Check flink hosts status
// 4. Create epoll for input socket
// 5. Wait connection in input socket
// 6. Get request
// 7. Handle request (get host/request)
// 8. Send request to flink host
// 9. Get response
// 10. Handle response
// 11. Send response in front

object Main {
	def main(arg: Array[String]): Unit = {
		println("Backend start")
//		var line = new String
//		do {
//			line = Console.readLine()
//			println(s"i don't now this command")
//		} while (line != "exit")

		// Create socket for front
		val ipAddress: InetAddress = InetAddress.getByName("127.0.0.1")
		val port = 1111
		val queueLength = 100
		val server = new ServerSocket(port, queueLength, ipAddress)
		// Create connection for flink
		val ipAddressFlink: InetAddress = InetAddress.getByName("127.0.0.1")
		val portFlink = 8081
		val clientFlink = new Socket(ipAddressFlink, portFlink)

		// Create client connections for front
		val client = server.accept()
//		val tmp = new java.nio.

		// Create input and output buffer for Front
		val in = new BufferedReader(new InputStreamReader(client.getInputStream))
		val out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream))
		// Create input and output buffer for Flink
		//		val inFlink = new BufferedReader(new InputStreamReader(clientFlink.getInputStream))
		//		val outFlink = new BufferedWriter(new OutputStreamWriter(clientFlink.getOutputStream))
		val inFlink = new DataInputStream(clientFlink.getInputStream)
		val outFlink = new DataOutputStream(clientFlink.getOutputStream)

		// Create queue for front
//		val queue = new ReferenceQueue[Socket]()

		// Read request from front
		val message = new ArrayBuffer[String]
		message += in.readLine()
		while (message.apply(message.length - 1).nonEmpty) {
			message += in.readLine()
//			println(message.mkString("\n") + "| = " + message.apply(if (message.length > 0) message.length - 1 else 0).length)
		}
		println(s"Get message: ${message.mkString("\n")}")

		// Send to Flink
		println(message.mkString("\n"))
		val str: String = message.mkString("\n") + "\n"
		outFlink.writeUTF(str)
		println("Write for Flink Ok")
		message.clear()
		println(message.mkString("\n") + " ok")
//		println(inFlink.readLine() + "12")
		message += inFlink.readLine()
		println(s"Get from Flink ${message.toString()}")
		while (message.apply(message.length - 1).nonEmpty) {
			message += inFlink.readLine()
		}
		// Send response
		println("fine")
		out.write(message.toString()) //("HTTP/1.1 200 OK\n\n")
		out.flush()
		outFlink.flush()
		println("fine 2")

		client.close()
		println("fine 3")
		in.close()
		inFlink.close()
		println("fine 4")
		out.close()
		outFlink.close()
		println("fine 5")

		import java.net.InetSocketAddress
		import java.net.ServerSocket
		import java.nio.ByteBuffer
		import java.nio.channels.SelectableChannel
		import java.nio.channels.SelectionKey
		import java.nio.channels.Selector
		import java.nio.channels.ServerSocketChannel
		import java.nio.channels.SocketChannel
		import java.util


		object SelectorDemo {
			var PORT_NUMBER = 1234

			@throws[Exception]
			def main(argv: Array[String]): Unit = {
				new SelectorDemo().go(argv)
			}
		}
		class SelectorDemo {
			@throws[Exception]
			def go(argv: Array[String]): Unit = {
				var port = SelectorDemo.PORT_NUMBER
				if (argv.length > 0) { // Override default listen port
					port = argv(0).toInt
				}
				System.out.println("Listening on port " + port) // Allocate an unbound server socket channel

				val serverChannel = ServerSocketChannel.open // Создать новый канал
				val serverSocket = serverChannel.socket // Получить соединение с сокетом из канала
				val selector = Selector.open // Создать новый селектор
				serverSocket.bind(new InetSocketAddress(port)) // Привязать сокетное соединение к порту

				serverChannel.configureBlocking(false) // Установить канал в неблокирующий режим. Только неблокирующий режим может использовать преимущества nio. Канал сокета может быть установлен неблокирующим, а канал файла не может быть неблокирующим.

				serverChannel.register(selector, SelectionKey.OP_ACCEPT) // Зарегистрировать этот канал в селекторе, OP_ACCEPT, если он заинтересован в работе, ожидает подключения

				while ( {
					true
				}) { // Циклически выбирайте подготовленную клавишу выбора из селектора, ключ должен поддерживать соответствующие отношения между каналом и селектором
					val n = selector.select // Получить количество подготовленных клавиш селектора от селектора
					if (n == 0) {
						continue //todo: continue is not supported
						// nothing to do

						// Get an iterator over the set of selected keys}
						val it = selector.selectedKeys.Iterator // Перебирать все подготовленные ключи выбора
						while ( {
							it.hasNext
						}) {
							val key = it.next.asInstanceOf[SelectionKey]
							if (key.isAcceptable) { // Если ключ ожидает подключения
								val server = key.channel.asInstanceOf[ServerSocketChannel] // Получить готовый канал сокета сервера из смены ключа
								val channel = server.accept // Получить это соединение сокета из канала сокета сервера
								registerChannel(selector, channel, SelectionKey.OP_READ) // Зарегистрировать соединение как читаемое рабочее состояние

								sayHello(channel) // Отправляем данные в это сокетное соединение

								// Is there data to read on this channel?}
								if (key.isReadable) { // в следующий раз, когда ссылка будет читаемой
									readDataFromSocket(key) // Получить данные этой ссылки на сокет и отобразить их

									// Remove key from selected set; it's been handled}
									it.remove() // Удалить подготовленный ключ, который был выполнен на этот раз, и выполнить selector.select () в следующий раз, все еще можно выбрать все подготовленные ключи

								}
							}
						}

						@throws[Exception]
						protected def registerChannel(selector: Selector, channel: SelectableChannel, ops: Int): Unit = {
							if (channel == null) return
							channel.configureBlocking(false) // Установить канал в неблокирующий режим

							channel.register(selector, ops)
						}

						private val buffer = ByteBuffer.allocateDirect(1024)

						@throws[Exception]
						protected def readDataFromSocket(key: SelectionKey): Unit = {
							val socketChannel = key.channel.asInstanceOf[SocketChannel]
							var count = 0
							buffer.clear
							while ( {
								(count = socketChannel.read(buffer)) > 0
							}) { // Отделить данные от канала
								buffer.flip // Стандартные данные этого канала читаемы

								while ( {
									buffer.hasRemaining
								}) socketChannel.write(buffer) // Запись данных в канал
								buffer.clear
								if (count < 0) socketChannel.close()
							}
						}

						@throws[Exception]
						private def sayHello(channel: SocketChannel): Unit = {
							buffer.clear
							buffer.put("Hi there!\r\n".getBytes)
							buffer.flip
							channel.write(buffer)
						}
					}
	}
}
