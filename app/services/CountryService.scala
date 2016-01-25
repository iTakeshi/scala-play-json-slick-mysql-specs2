package services

import scala.concurrent.Future

import models.{Country, Countries}

object CountryService {
  def listAllCountries: Future[Seq[Country]] = {
    Countries.listAll
  }
}
