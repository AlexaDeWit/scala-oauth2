import com.github.alexadewit.scala_oauth2._
import org.scalatest._

class AccessTokenRequestSpec extends FlatSpec {

  "base 64 encoded keys" should "correctly encode the result" in {
    val keys = OAuth2Keys(
      "3rdparty_clientid",
      "jkfopwkmif90e0womkepowe9irkjo3p9mkfwe"
    )
    val expected = "M3JkcGFydHlfY2xpZW50aWQ6amtmb3B3a21pZjkwZTB3b21rZXBvd2U5aXJram8zcDlta2Z3ZQ=="
    assert( AccessTokenRequestUtils.base64EncodedKeys( keys ) == expected )

  }

}

