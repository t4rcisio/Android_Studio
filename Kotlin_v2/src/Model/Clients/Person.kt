package Model.Clients

open class Person {

    private lateinit var name: String
    private lateinit var birthday: String
    private lateinit var cpf: String
    private lateinit var gender: Gender
    private lateinit var phone: String
    private lateinit var address: String
    private lateinit var email: String

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getBirthday(): String {
        return birthday
    }

    fun setBirthday(birthday: String) {
        this.birthday = birthday
    }

    fun getCpf(): String {
        return cpf
    }

    fun setCpf(cpf: String) {
        this.cpf = cpf
    }

    fun getGender(): Gender {
        return gender
    }

    fun setGender(gender: Gender) {
        this.gender = gender
    }

    fun getPhone(): String {
        return phone
    }

    fun setPhone(phone: String) {
        this.phone = phone
    }

    fun getAddress(): String {
        return address
    }

    fun setAddress(address: String) {
        this.address = address
    }

    fun getEmail(): String {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }
}