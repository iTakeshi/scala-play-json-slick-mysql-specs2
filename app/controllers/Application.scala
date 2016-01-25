package controllers

import play.api.mvc._
import play.api.libs.json._
import scala.concurrent.ExecutionContext.Implicits.global

import services.CountryService

class Application extends Controller {
  def index = Action.async {
    CountryService.listAllCountries map { countries =>
      Ok(Json.toJson(countries))
    }
  }
}
