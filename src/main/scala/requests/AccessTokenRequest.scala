package com.github.alexadewit.scala_oauth2

import org.apache.commons.codec.binary.Base64
import scalaz._, scalaz.syntax.either._, scalaz.concurrent._

import org.http4s._
import org.http4s.Http4s._
import org.http4s.util._

trait AccessTokenRequest[Provider] {

  def build(
    requestUri: Uri,
    authCode: String,
    keys: OAuth2Keys,
    host: String ) : Task[Request]
}

object AccessTokenRequestUtils {

  def base64EncodedKeys( keys: OAuth2Keys, delimiter: String = ":" ) : String = {
    Base64.encodeBase64String (
      s"${keys.clientId}${delimiter}${keys.secretKey}".getBytes()
    )
  }

}

