package models

import play.api.Play
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.db.slick.DatabaseConfigProvider
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import slick.driver.JdbcProfile
import slick.driver.MySQLDriver.api._

case class Country(id: Long, name: String, capital: String)

object Country {
  implicit val countryFormat: Format[Country] = (
    (__ \ "id").format[Long] and
    (__ \ "name").format[String] and
    (__ \ "capital").format[String]
  )(Country.apply, unlift(Country.unapply))
}

class CountryTableDef(tag: Tag) extends Table[Country](tag, "country") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def capital = column[String]("capital")

  override def * =
    (id, name, capital) <>((Country.apply _).tupled, Country.unapply)
}

object Countries {
  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  val countries = TableQuery[CountryTableDef]

  def listAll: Future[Seq[Country]] = dbConfig.db.run(countries.result)
}
