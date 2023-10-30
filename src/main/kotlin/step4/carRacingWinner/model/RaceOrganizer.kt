package step4.carRacingWinner.model

import step4.carRacingWinner.RaceRuleType

data class CarData(val name: String = "", val curPosition: Int)
data class RaceResult(val round: Int, val carData: List<CarData>)

class RaceOrganizer(private val cars: List<Car>) {
    private var results: MutableList<RaceResult> = mutableListOf();
    private fun tryRound(cars: List<Car>, rule: RaceRuleType) {
        this.cars.forEach { it.tryRace(rule) }
    }

    fun startRace(tryCount: Int, rule: RaceRuleType) {
        for (i in 0 until tryCount) {
            tryRound(cars, rule)
            val result = RaceResult(round = i + 1, carData = cars.map { CarData(curPosition = it.getCurPosition(), name = it.getCarName()) })
            results.add(result)
        }
    }

    fun getRaceResult() = this.results
}
