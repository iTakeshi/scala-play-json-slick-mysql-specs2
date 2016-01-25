package models

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Country(id: Long, name: String, capital: String)

object Country {
  implicit val countryFormat: Format[Country] = (
    (__ \ "id").format[Long] and
    (__ \ "name").format[String] and
    (__ \ "capital").format[String]
  )(Country.apply, unlift(Country.unapply))
}

object Countries {
  var countries: Seq[Country] = Seq()
  countries = countries :+ Country(0, "Japan", "Tokyo") // dummy data

  def listAll: Seq[Country] = countries
}
