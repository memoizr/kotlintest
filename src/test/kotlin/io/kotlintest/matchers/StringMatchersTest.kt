package io.kotlintest.matchers

import io.kotlintest.specs.FreeSpec

class StringMatchersTest : FreeSpec(), Matchers {
  init {

    "should endWith" - {
      "should test strings" {
        "hello" should endWith("o")
        "hello" should startWith("")
        "" should startWith("")
        shouldThrow<AssertionError> {
          "" should endWith("h")
        }
        shouldThrow<AssertionError> {
          "hello" should endWith("goodbye")
        }
      }
    }

    "should startWith" - {
      "should test strings" {
        "hello" should startWith("h")
        "hello" should startWith("")
        "" should startWith("")
        shouldThrow<AssertionError> {
          "" should startWith("h")
        }
        shouldThrow<AssertionError> {
          "hello" should startWith("goodbye")
        }
      }
    }

    "Matchers should start with x" - {
      "should compare prefix of string" {
        "bibble" should start with ""
        "bibble" should start with "bib"
        "bibble" should start with "bibble"
      }
      "should fail if string does not start with x" {
        val t = try {
          "bibble" should start with "vv"
          true
        } catch(e: AssertionError) {
          false
        }
        t shouldBe false
      }
    }
    "should haveLength(5)" - {
      "should compare length of string" {
        "bibble" should haveLength(6)
        "" should haveLength(0)
        shouldThrow<AssertionError> {
          "" should haveLength(3)
        }
      }
    }
    "Matchers should end with x" - {
      "should compare prefix of string" {
        "bibble" should end with ""
        "bibble" should end with "ble"
        "bibble" should end with "bibble"
      }
      "should fail if string does not end with x" {
        val t = try {
          "bibble" should end with "qwe"
          true
        } catch(e: AssertionError) {
          false
        }
        t shouldBe false
      }
    }
    "Matchers should have substring x" - {
      "should test string contains substring" {
        "bibble" should have substring ""
        "bibble" should have substring "bb"
        "bibble" should have substring "bibble"
      }
      "should fail if string does not contains substring" {
        val t = try {
          "bibble" should have substring "qweqwe"
          true
        } catch(e: AssertionError) {
          false
        }
        t shouldBe false
      }
    }
    "String should match regex" - {
      "should test string matches regular expression" {
        "sam" should match("sam")
        "bibble" should match("bibb..")
        "foo" should match(".*")
      }
    }
  }
}