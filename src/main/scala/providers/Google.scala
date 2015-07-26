package com.github.alexadewit.scala_oauth2.providers

import com.github.alexadewit.scala_oauth2.Provider
case class Googlelike(
  host: Option[String],
  tokenEndpoint: String,
  revokeEndpoint: String ) extends Provider(
    host,
    tokenEndpoint,
    revokeEndpoint ) {
  
  /* I think it works like this...? Typeclasses!
  implicit object requestBuilder extends AccessTokenRequestBuilder[Google] {
  }
  */
}
