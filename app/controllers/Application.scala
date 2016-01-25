package controllers

import play.api.mvc._
import play.api.libs.json._

import services.CountryService

class Application extends Controller {
  def index = Action {
    Ok(Json.toJson(CountryService.listAllCountries))
  }
}
