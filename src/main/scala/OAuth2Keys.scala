package com.github.alexadewit.scala_oauth2

import scalaz._, scalaz.syntax.either._

case class OAuth2Keys( clientId: String, secretKey: String )

//No JSON codec defined for keys as it is expected that they not ever be made available
//through JSON, and only through Request objects to the Provider.
