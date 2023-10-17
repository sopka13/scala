package ch_06

import ch_06.Accounts.getUniqueNumber

object Main {
	def main(args: Array[String]): Unit = {
		println(getUniqueNumber)
		val pp = new Accounts(10)
		println(pp.id)
	}
}
