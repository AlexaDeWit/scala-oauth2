package com.github.alexadewit.scala_oauth2.providers

import com.github.alexadewit.scala_oauth2.AdditionalFields

import org.http4s._, Http4s._

case class GoogleFields( redirectUri: Uri ) extends AdditionalFields[Googlelike]
