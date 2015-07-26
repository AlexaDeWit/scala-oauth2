import com.github.alexadewit.scala_oauth2._
import org.scalatest._
import argonaut._, Argonaut._, DecodeResult._

class OAuth2KeysSpec extends FlatSpec {

 case class TestProvider(
  host: String,
  tokenEndpoint: String,
  revokeEndpoint: String ) extends Provider(
    host,
    tokenEndpoint,
    revokeEndpoint )

  "base 64 encoded keys" should "correctly encode the result" in {
    val keys = OAuth2Keys[TestProvider](
      "3rdparty_clientid",
      "jkfopwkmif90e0womkepowe9irkjo3p9mkfwe"
    )
    val expected = "M3JkcGFydHlfY2xpZW50aWQ6amtmb3B3a21pZjkwZTB3b21rZXBvd2U5aXJram8zcDlta2Z3ZQ=="
    assert( keys.base64Encoded == expected )
  }

}
