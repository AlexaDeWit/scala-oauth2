package com.github.alexadewit.scala_oauth2.providers

import com.github.alexadewit.scala_oauth2.OAuth2Keys
import org.http4s._, Http4s._

case class GoogleCredentials( keys: OAuth2Keys, redirectUri: Uri ) {
}

