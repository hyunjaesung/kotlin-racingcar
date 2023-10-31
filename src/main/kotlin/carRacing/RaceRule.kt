package carRacing

import carRacing.model.Car
import kotlin.random.Random


object RaceRule {
    val over4CanGo = { _: Car -> Random.nextInt(0, 10) in 4 until 10}
}

typealias RaceRuleType = (car: Car) -> Boolean
