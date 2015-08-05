package com.github.alexadewit.scala_oauth2.providers

import com.github.alexadewit.scala_oauth2._
import scalaz._, scalaz.syntax.either._, scalaz.concurrent._
import org.http4s._, Http4s._
import org.http4s.client._
import org.http4s.util._



class GooglelikeFormat[P <: GoogleCredentials] extends ProviderFormat[GoogleCredentials] {

  val accessTokenRequestBuilder = new AccessTokenRequestBuilder[P]{
    override def build( providerConfig: P )(
      requestUri: Uri,
      authCode: String
    ) : Task[Request] = {
      
      Request(
        Method.POST,
        requestUri,
        HttpVersion.`HTTP/1.1`
        ).withBody(
          UrlForm(
            accessTokenRequestMap(
              authCode,
              providerConfig.keys,
              providerConfig.redirectUri
            )
          )
        )
    }

    def accessTokenRequestMap(
      authCode: String,
      keys: OAuth2Keys,
      redirectUri: Uri
      ) : Map[String,Seq[String]] = {

        Map(
          "code" -> Seq(authCode),
          "client_id" -> Seq(keys.clientId),
          "client_secret" -> Seq(keys.secretKey),
          "redirerect_uri" -> Seq(redirectUri.toString),
          "grant_type" -> Seq("authorization_code")
        )
    }
  } 

}

object Google {

  val providerFormat = new GooglelikeFormat[GoogleCredentials]

  implicit val googleEndpoints = Endpoints(
    "www.googleapis.com",
    uri("https://accounts.google.com/o/oauth2/auth"),
    uri("https://accounts.google.com/o/oauth2/revoke")
  )

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
