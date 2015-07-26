package com.github.alexadewit.scala_oauth2

import scalaz._, scalaz.syntax.either._, scalaz.concurrent._

abstract class Provider(
  host: String,
  tokenEndpoint: String,
  revokeEndpoint: String )
