package com.github.alexadewit.scala_oauth2

import org.http4s.Headers

trait AdditionalFields[P] {

  def headerPart : Headers
  def bodyPart : Map[String,Seq[String]]
}
