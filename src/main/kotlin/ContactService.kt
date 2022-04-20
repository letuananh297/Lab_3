import java.net.URL

interface ContactService {
    fun addContact(person: Person, contact: Contact)
    fun addPhone(person: Person, number: String, type: PhoneType)
    fun addEmail(person: Person, email: String)
    fun addAddress(person: Person, city: String, street: String, house: Int, apartment: Int)
    fun addLink(person: Person, name: String, link: URL)
    fun removeContact(person: Person, contact: Contact)
    fun removeAllContactPerson(person: Person)
    fun removePerson(person: Person)
    fun getPersonContact(person: Person): List<Contact>
    fun getPersonPhone(person: Person): List<Contact.Phone>
    fun getPersonEmail(person: Person): List<Contact.Email>
    fun getPersonAddress(person: Person): List<Contact.Address>
    fun getPersonLink(person: Person): List<Contact.ProfileLink>
    fun getAllPeople(): List<Person>
    fun getAllContact(): Map<Person, List<Contact>>
    fun findPersonByName(subString: String): List<Person>
}