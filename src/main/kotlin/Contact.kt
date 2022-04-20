import java.net.URL

enum class PhoneType(private val type: String) {
    HOME("Home"),
    MOBILE("Mobile"),
    WORK("Work");

    override fun toString(): String {
        return type
    }
}

sealed class Contact {
    data class Phone(val number: String, val type: PhoneType) : Contact() {
        override fun toString(): String {
            return "$type: $number"
        }
    }

    data class Email(val email: String) : Contact() {
        override fun toString(): String {
            return email
        }
    }

    data class Address(val city: String, val street: String, val house: Int, val apartment: Int) : Contact() {
        override fun toString(): String {
            return "$city, ул. $street, д. $house, кв. $apartment"
        }
    }

    data class ProfileLink(val name: String, val link: URL) : Contact() {
        override fun toString(): String {
            return "$name - $link"
        }
    }
}