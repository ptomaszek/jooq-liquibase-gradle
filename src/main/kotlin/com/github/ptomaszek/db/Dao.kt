package com.github.ptomaszek.db

fun main() {
    println(
        "Hello, I have an access to jOOQ fields generated from plain SQLs. " +
                "No need to connect to a DB! " +
                "Proof: ${Tables.PERSON.ADDRESS}"
    )

    //'car' table was dropped -> no jOOQ reference
    //val carId = Tables.CAR.ID
}
