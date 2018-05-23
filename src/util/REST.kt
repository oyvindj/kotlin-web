package util

import org.w3c.dom.events.Event
import org.w3c.dom.get
import org.w3c.xhr.XMLHttpRequest
import kotlin.js.Json
import kotlin.js.Date

class REST() {
    fun fetch(cb: ((resp: Array<Person>) -> Unit)) {
        val url = "http://localhost:8080/people"
        val req = XMLHttpRequest()
        req.onloadend = fun(event: Event){
            val text = req.responseText
            println(text)
            val objArray  = JSON.parse<Array<Person>>(text)
            objArray.forEach {
                println("element: " + JSON.stringify(it))
                //println(it)
            }
            cb(objArray)
        }
        req.open("GET", url, true)
        req.send()
    }
}

data class Person(val name: String, val createdOn: Date = Date()) {
    var id: String? = null
}