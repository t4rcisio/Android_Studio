package Model.Clients

class Client : Person() {

    private  var credit: Double = 0.0
    private lateinit var creationDate: String
    private  var id: Int = 0

    fun getCredit(): Double{
        return this.credit
    }
    fun setCredit(credit: Double){
        this.credit = credit
    }
    fun setCreationDate(data: String){
        this.creationDate = data
    }
    fun getCreationDate(): String{
        return this.creationDate
    }
    fun getId(): Int{
        return this.id
    }
    fun setId(id: Int){
        this.id = id
    }







}