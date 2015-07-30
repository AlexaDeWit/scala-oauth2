package com.github.alexadewit.scala_oauth2

import org.apache.commons.codec.binary.Base64

case class OAuth2Keys[P]( clientId: String, secretKey: String ) {

  def base64EncodedKeys : String = {
    Base64.encodeBase64String (
      s"${clientId}:${secretKey}".getBytes()
    )
  }

}
