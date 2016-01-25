package services

import models.{Country, Countries}

object CountryService {
  def listAllCountries: Seq[Country] = {
    Countries.listAll
  }
}
