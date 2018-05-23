package app

import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*
import logo.*
import ticker.*
import util.*

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("App-header") {
            logo()
            h2 {
                +"Welcome to Java Faggruppe with Kotlin"
            }
        }
        h2 {
            +"Hei Java Faggruppe!!!"
        }
        div {
            button {
                +"Klikk Meg!!!"
                attrs.onClickFunction = {
                    console.log("Knapp klikket....")
                    val rest = util.REST()
                    rest.fetch({
                        console.log("got " + it.size + " people response")
                    })
                }
            }
        }
        p("App-intro") {
            +"To get started, edit "
            code { +"app/App.kt" }
            +" and save to reload."
        }
        p("App-ticker") {
            ticker()
        }
    }
}

fun RBuilder.app() = child(App::class) {}
