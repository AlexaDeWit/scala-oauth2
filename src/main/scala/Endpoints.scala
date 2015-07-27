package com.github.alexadewit.scala_oauth2

import org.http4s.Uri

case class Endpoints[P]( 
  host: String,
  accessTokenEndpoint: Uri,
  revokeTokenEndpoint: Uri
  )
