package traits

object Main {
  def main(args: Array[String]): Unit = {
    printf(s"main start\n")

    val masha = new Woman("Masha", 10) with SayYourGender
    val nastya = new Woman("Nastya", 12)

    // Type definitions
    val human_0: Human = new Man("Tom", 12)
    val human_1: Philosophical = new Man("Bob", 13)
    val human_2: Ordered[Human] = new Woman("Kate", 14)
    println(
      s"human_0 name:   ${human_0.name}\n" +
//      s"human_1 name:   ${human_1.name}\n" +    // Error
//      s"human_2 name:   ${human_2.name}\n"      // Error
      ""
    )

    // Use dynamic binding
    println(s"Say your gender: ${masha.gender}\n")

    // Operations
    println(
      s"masha name:       ${masha.name}\n" +
      s"nastya name:      ${nastya.name}\n" +
      s"masha age:        ${masha.age}\n" +
      s"nastya age:       ${nastya.age}\n" +
      s"masha == nastya:  ${masha == nastya}\n" +
      s"masha > nastya:   ${masha > nastya}\n" +
      s"masha < nastya:   ${masha < nastya}\n" +
      s"masha >= nastya:  ${masha >= nastya}\n" +
      s"masha <= nastya:  ${masha <= nastya}\n"
    )
  }
}
