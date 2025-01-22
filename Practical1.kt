// Define the User data class
data class User(val name: String, val age: Int, val gender: String)

fun main() {
    var numberOfUsers: Int

    // Keep asking until valid input is given for the number of users
    while (true) {
        print("How many users would you like to enter? ")
        val input = readLine()

        // Try to convert the input to an integer, and handle invalid input
        numberOfUsers = input?.toIntOrNull() ?: -1

        if (numberOfUsers > 0) {
            break  // Exit the loop if the input is valid
        } else {
            println("Invalid input. Please enter a positive number.")
        }
    }

    // Create a mutable list to store user data
    val userList = mutableListOf<User>()

    // Collect user data
    for (i in 1..numberOfUsers) {
        println("\nEntering details for User #$i")

        print("Enter name: ")
        val name = readLine() ?: "Unknown"

        // Ask for valid age input
        var age: Int
        while (true) {
            print("Enter age: ")
            val ageInput = readLine()?.toIntOrNull()

            if (ageInput != null && ageInput > 0) {
                age = ageInput
                break  // Exit the loop if the input is valid
            } else {
                println("Invalid age. Please enter a positive number for age.")
            }
        }

        // Ask for valid gender input
        var gender: String
        while (true) {
            print("Enter gender (M for Male, F for Female, O for Other): ")
            gender = readLine()?.uppercase() ?: "Unknown"

            if (gender == "M" || gender == "F" || gender == "O") {
                break  // Exit the loop if the input is valid
            } else {
                println("Invalid input. Please enter M, F, or O.")
            }
        }

        // Add the user to the list
        userList.add(User(name, age, gender))
    }

    // Display the user information and check drinking eligibility
    println("\nResults:")
    for (user in userList) {
        if (user.age >= 18) {
            println("${user.name} (${user.gender}) is eligible to drink.")
        } else {
            println("${user.name} (${user.gender}) is not eligible to drink.")
        }
    }
}
