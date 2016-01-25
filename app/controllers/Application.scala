package controllers

import play.api.mvc._
import play.api.libs.json._

import models.{Country, Countries}

class Application extends Controller {
  def index = Action {
    Ok(Json.toJson(Countries.listAll))
  }
}
