package com.github.alexadewit.scala_oauth2

import scalaz._, scalaz.syntax.either._, scalaz.concurrent._

import org.http4s._
import org.http4s.Http4s._
import org.http4s.client._
import org.http4s.util._
import org.http4s.Status.NotFound
import org.http4s.Status.ResponseClass.Successful

import AccessTokenJson._

trait AccessTokenRequestBuilder[P] {

  def build(
    requestUri: Uri,
    authCode: String,
    keys: OAuth2Keys[P],
    host: String ) : Task[Request]

}

object AccessTokenRequest {

  def accessToken(
    request: Task[Request],
    client: Client = org.http4s.client.blaze.defaultClient
  ) : Task[ String \/ AccessToken ] = {

    client( request ).flatMap {
      case Successful( jsonResp ) => jsonResp.as[AccessToken].map( _.right )
      case NotFound( resp )       => Task.now("404 Not Found".left)
      case resp                   => Task.now(s"Failed: ${resp}".left)
    }

  }
}

