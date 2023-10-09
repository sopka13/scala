package ch_06

import ch_06.Accounts.getUniqueNumber

class Accounts(startBalance: Int) {
	val id: Int = getUniqueNumber
	private var balance = startBalance
	def Deposit(sum: Int): Unit = balance += sum
}

object Accounts {
	private var lastNumber = 0
	def getUniqueNumber: Int = { lastNumber += 1; lastNumber - 1 }
}
