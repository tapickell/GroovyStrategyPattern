String.metaClass.upcase = {->
    def string_buffer = new StringBuffer()
    delegate.each {
        string_buffer << (Character.isLowerCase(it as char) ? Character.toUpperCase(it as char) : it as char)
    }
    string_buffer.toString()
}

String.metaClass.downcase = {->
    def string_buffer = new StringBuffer()
    delegate.each {
        string_buffer << (Character.isUpperCase(it as char) ? Character.toLowerCase(it as char) : it as char)
    }
    string_buffer.toString()
}

interface Strategy { def call(string) }

class StrategyOne implements Strategy {

    def call(string) {
        string.downcase().reverse().capitalize()
    }
}

class StrategyTwo implements Strategy {

    def call(string) {
        string.downcase().capitalize()
    }
}

class StrategyThree implements Strategy {

    def call(string) {
        string.upcase()
    }
}


def test_string = "groovy stRAtEGy PAttERn"

Strategy[] stringManipulationStrategies = [new StrategyOne(), new StrategyTwo(), new StrategyThree()]

stringManipulationStrategies.each { strategy ->
    println strategy.call(test_string)
}
