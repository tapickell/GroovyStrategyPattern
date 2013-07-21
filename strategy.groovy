String.metaClass.upcase = {->
    def string_buffer = new StringBuffer()
    delegate.each {
        string_buffer << (Character.isLowerCase(it as char) ? Character.toUpperCase(it as char) : it as char)
    }
    string_buffer.toString()
}

interface Strategy { def call(string) }

class StrategyOne implements Strategy {

    def call(string) {
        string.reverse()
    }
}

class StrategyTwo implements Strategy {

    def call(string) {
        string.capitalize()
    }
}

class StrategyThree implements Strategy {

    def call(string) {
        string.upcase()
    }
}


def test_string = "groovy strategy pattern"

Strategy[] stringManipulationStrategies = [new StrategyOne(), new StrategyTwo(), new StrategyThree()]

stringManipulationStrategies.each { strategy ->
    println strategy.call(test_string)
}
