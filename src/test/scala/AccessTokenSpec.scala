import com.github.alexadewit.scala_oauth2._
import org.scalatest._
import argonaut._, Argonaut._, DecodeResult._
import AccessTokenJson._

class AccessTokenSpec extends FlatSpec {
  

  "parsing with a null refresh token" should "result in a correct access token with a None" in {
    val inputJson = """
    {
      "access_token": "uNEEha_WpiaA2",
      "token_type": "Bearer",
      "expires_in": 300,
      "refresh_token": null
    }
    """
    val resultToken = Parse.decodeOption[AccessToken]( inputJson ).get
    val expectedToken = AccessToken( "uNEEha_WpiaA2", "Bearer", 300, None )
    assert( resultToken == expectedToken )
  }

  "parsing with a refresh token" should "result in a correct access token with a Some" in {
    val inputJson = """
    {
      "access_token": "uNEEha_WpiaA2",
      "token_type": "Bearer",
      "expires_in": 300,
      "refresh_token": "SDHDSFS89dsfsASlka21"
    }
    """
    val resultToken = Parse.decodeOption[AccessToken]( inputJson ).get
    val expectedToken = AccessToken( "uNEEha_WpiaA2", "Bearer", 300, Some("SDHDSFS89dsfsASlka21" )) 
    assert( resultToken == expectedToken )
  }
}
