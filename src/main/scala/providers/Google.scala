package com.github.alexadewit.scala_oauth2.providers

import com.github.alexadewit.scala_oauth2._
import scalaz._, scalaz.syntax.either._, scalaz.concurrent._
import org.http4s._, Http4s._
import org.http4s.client._
import org.http4s.util._


case class Googlelike(
  host: String,
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

object Googlelike {
  /*
  implicit val accessTokenRequestBuilder = new AccessTokenRequestBuilder[Googlelike] {
    def build(
      requestUri: Uri,
      authCode: String,
      keys: OAuth2Keys[Googlelike],
      host: String ) : Task[Request] = {
    }
  }
  */
}
