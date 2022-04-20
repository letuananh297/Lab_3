import java.net.URL
import java.util.logging.Logger

val log: Logger = Logger.getLogger(DataBase()::class.java.name)

class DataBase : ContactService {
    private val mapContact: MutableMap<Person, MutableList<Contact>> = mutableMapOf()

    override fun addContact(person: Person, contact: Contact) {
        if (mapContact.contains(person)) {
            mapContact[person]!!.add(contact)
        } else {
            mapContact[person] = mutableListOf()
            mapContact[person]!!.add(contact)
        }
    }

    override fun addPhone(person: Person, number: String, type: PhoneType) {
        addContact(person, Contact.Phone(number, type))
        log.info("New phone number has been added to $person.")
    }

    override fun addEmail(person: Person, email: String) {
        addContact(person, Contact.Email(email))
        log.info("New email has been added to $person.")
    }

    override fun addAddress(person: Person, city: String, street: String, house: Int, apartment: Int) {
        addContact(person, Contact.Address(city, street, house, apartment))
        log.info("New address has been added to $person.")
    }

    override fun addLink(person: Person, name: String, link: URL) {
        addContact(person, Contact.ProfileLink(name, link))
        log.info("New profile link has been added to $person.")
    }

    override fun removeContact(person: Person, contact: Contact) {
        if (!mapContact.contains(person)) {
            error("$person is not exist.")
        } else {
            if (!mapContact[person]!!.contains(contact)) {
                error("$person does not have $contact.")
            } else {
                mapContact[person]!!.remove(contact)
                log.info("$person's contact has been deleted.")
            }
        }
    }

    override fun removeAllContactPerson(person: Person) {
        if (!mapContact.contains(person)) {
            error("$person is not exist.")
        } else {
            mapContact[person]!!.clear()
            log.info("All $person's contacts have been deleted.")
        }
    }

    override fun removePerson(person: Person) {
        if (!mapContact.contains(person)) {
            error("$person is not exist.")
        } else {
            mapContact.remove(person)
            log.info("$person has been deleted.")
        }
    }

    override fun getPersonContact(person: Person): List<Contact> {
        if (!mapContact.contains(person)) {
            error("$person is not exist.")
        } else {
            return mapContact[person]!!.toList()
        }
    }

    override fun getPersonPhone(person: Person): List<Contact.Phone> {
        if (!mapContact.contains(person)) {
            error("$person is not exist.")
        } else {
            val listPhone: MutableList<Contact.Phone> = mutableListOf()
            mapContact[person]!!.forEach {
                if (it is Contact.Phone) {
                    listPhone.add(it)
                }
            }
            return listPhone.toList()
        }
    }

    override fun getPersonEmail(person: Person): List<Contact.Email> {
        if (!mapContact.contains(person)) {
            error("$person is not exist.")
        } else {
            val listEmail: MutableList<Contact.Email> = mutableListOf()
            mapContact[person]!!.forEach {
                if (it is Contact.Email) {
                    listEmail.add(it)
                }
            }
            return listEmail.toList()
        }
    }

    override fun getPersonAddress(person: Person): List<Contact.Address> {
        if (!mapContact.contains(person)) {
            error("$person is not exist.")
        } else {
            val listAddress: MutableList<Contact.Address> = mutableListOf()
            mapContact[person]!!.forEach {
                if (it is Contact.Address) {
                    listAddress.add(it)
                }
            }
            return listAddress.toList()
        }
    }

    override fun getPersonLink(person: Person): List<Contact.ProfileLink> {
        if (!mapContact.contains(person)) {
            error("$person is not exist.")
        } else {
            val listLink: MutableList<Contact.ProfileLink> = mutableListOf()
            mapContact[person]!!.forEach {
                if (it is Contact.ProfileLink) {
                    listLink.add(it)
                }
            }
            return listLink.toList()
        }
    }

    override fun getAllPeople(): List<Person> {
        val listPerson: MutableList<Person> = mutableListOf()
        mapContact.keys.forEach {
            listPerson.add(it)
        }
        return listPerson
    }

    override fun getAllContact(): Map<Person, List<Contact>> {
        return mapContact
    }

    override fun findPersonByName(subString: String): List<Person> {
        val listPerson: MutableList<Person> = mutableListOf()
        mapContact.keys.forEach {
            if (it.firstName == subString || it.lastName == subString) {
                listPerson.add(it)
            }
        }
        return listPerson
    }
}