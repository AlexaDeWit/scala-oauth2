package com.github.alexadewit.scala_oauth2

import scalaz._, scalaz.syntax.either._, scalaz.concurrent._
import argonaut._, Argonaut._

import org.http4s._
import org.http4s.util._
import org.http4s.argonaut.jsonOf

case class AccessToken(
  token: String,
  tokenType: String,
  expiresIn: Int, 
  refreshToken: Option[String] ) {

}


object AccessToken {

  def from[P <: Provider]( endpoints: Endpoints[P] )
    ( authCode: String, keys: OAuth2Keys[P] )
    ( implicit requestBuilder: AccessTokenRequestBuilder[P] ) 
    : Task[String\/AccessToken] = {

    val reqTask = requestBuilder.build(
      endpoints.accessTokenEndpoint,
      authCode,
      keys,
      endpoints.host
    )
    AccessTokenRequest.accessToken( reqTask )
  }
}



object AccessTokenJson {
  implicit def accessTokenCodecJson : CodecJson[AccessToken] = {
    casecodec4( AccessToken.apply, AccessToken.unapply )(
      "access_token", "token_type", "expires_in", "refresh_token"
    )
  }

  implicit def accessTokenDecoder = jsonOf[AccessToken]
}

