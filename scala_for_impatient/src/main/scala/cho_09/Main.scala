package cho_09

import java.io.File

object Main {
	def main(args: Array[String]): Unit = {
		//
	}

	// iteration 1
	object FileMather_01 {
		private def filesHere = (new java.io.File(".")).listFiles

		def filesEnding(query: String): Array[File] =
			for (file <- filesHere; if file.getName.endsWith(query))
				yield file

		def fileContaining(query: String): Array[File] =
			for (file <- filesHere; if file.getName.contains(query))
				yield file

		def fileRegex(query: String): Array[File] =
			for (file <- filesHere; if file.getName.matches(query))
				yield file
	}

	// iteration 2
	object FileMather_02 {
		private def filesHere = (new java.io.File(".")).listFiles

		def filesMaching(query: String, macher: (String, String) => Boolean): Array[File] =
			for (file <- filesHere; if macher(file.getName, query))
				yield file

		def filesEnding(query: String): Array[File] =
			filesMaching(query, _.endsWith(_))

		def filesContains(query: String): Array[File] =
			filesMaching(query, _.contains(_))

		def filesMaches(query: String): Array[File] =
			filesMaching(query, _.matches(_))
	}

	// iteration 3
	object FileMather_03 {
		private def filesHere = (new java.io.File(".")).listFiles

		def filesMaching(macher: String => Boolean): Array[File] =
			for (file <- filesHere; if macher(file.getName))
				yield file

		def filesEnding(query: String): Array[File] =
			filesMaching(_.endsWith(query))

		def filesContains(query: String): Array[File] =
			filesMaching(_.contains(query))

		def filesMaches(query: String): Array[File] =
			filesMaching(_.matches(query))
	}
}