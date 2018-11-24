package com.avalia.protobuf.example

import com.avalia.protobuf.example.address_book.Person.{PhoneNumber, PhoneType}
import com.avalia.protobuf.example.address_book.{AddressBook, Person}
import com.typesafe.scalalogging.LazyLogging

object Hello extends LazyLogging with Greeting with App {



  private def getAddressBookSerialized = {

    val number = new PhoneNumber("1234567890", Some(PhoneType.MOBILE))
    val person = new Person("Rahul Shukla", 34, Some("blabla@gmail.com"), Seq(number))
    val ab = new AddressBook().addPeople(person)
    logger.debug(s"Phone Number : ${number.toString}")
    logger.debug(s"Person : ${person.toString}")
    logger.debug(s"Address Book : ${ab.toString}")
    ab.toByteArray
  }

  def deSerializeAddressBook(msg: Array[Byte]) = {
    val book = AddressBook.parseFrom(msg)
    logger.debug(s"Phone Number : ${book.people(0).phones(0).toString}")
    logger.debug(s"Person : ${book.people(0).toString}")
    logger.debug(s"Address Book : ${book.toString}")
  }

  deSerializeAddressBook(getAddressBookSerialized)

}

trait Greeting {
  lazy val greeting: String = "hello"
}
