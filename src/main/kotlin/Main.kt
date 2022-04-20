import java.net.URL

fun main() {
    val contacts = DataBase()

    val person1 = Person("Le", "Tuan Anh")
    val person2 = Person("Luong", "Van Duc")
    val person3 = Person("Nguyen", "Tuan Anh")

    contacts.addPhone(person1, "89111111111", PhoneType.MOBILE)
    contacts.addEmail(person1, "tuananh@gmail.com")
    contacts.addAddress(person1, "St.Petersburg", "Torzhkovskaya", 15, 50)
    contacts.addLink(person1, "VK", URL("https://vk.lta"))

    contacts.addPhone(person2, "89222222222", PhoneType.HOME)
    contacts.addEmail(person2, "vanduc@gmail.com")
    contacts.addAddress(person2, "St.Petersburg", "Torzhkovskaya", 15, 50)
    contacts.addLink(person2, "Facebook", URL("https://fb.lvd"))

    contacts.addPhone(person3, "89333333333", PhoneType.WORK)
    contacts.addEmail(person3, "tuananh@gmail.com")

    contacts.removeContact(person1, Contact.Email("tuananh@gmail.com"))
    contacts.removeContact(person1, Contact.Address("St.Petersburg", "Torzhkovskaya", 15, 50))
    contacts.removeAllContactPerson(person3)
    contacts.removePerson(person2)

    println(contacts.getAllContact())

    println(contacts.getAllPeople())

    println(contacts.getPersonContact(person1))

    println(contacts.findPersonByName("Tuan Anh"))
}