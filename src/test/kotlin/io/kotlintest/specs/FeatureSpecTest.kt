package io.kotlintest.specs

import io.kotlintest.ListStack

class FeatureSpecTest : FeatureSpec({
    feature("ListStack can have elements removed") {
        scenario("pop is invoked") {
            val stack = ListStack<String>()
            stack.push("hello")
            stack.push("world")
            stack.size() shouldBe 2
            stack.pop() shouldBe "world"
            stack.size() shouldBe 1
        }
    }

    feature("featurespec") {
        scenario("support config syntax") {
        }.config(invocations = 5)
    }
})

class FeatureSpecUsingInitTest : FeatureSpec() {

    init {

        feature("ListStack can have elements removed") {
            scenario("pop is invoked") {
                val stack = ListStack<String>()
                stack.push("hello")
                stack.push("world")
                stack.size() shouldBe 2
                stack.pop() shouldBe "world"
                stack.size() shouldBe 1
            }
        }

        feature("featurespec") {
            scenario("support config syntax") {
            }.config(invocations = 5)
        }
    }
}