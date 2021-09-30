package net.soy.algorithm

import net.soy.algorithm.level1.exercise.rectangularStar.Solution
import org.junit.Test

import kotlin.test.assertEquals

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SolutionTest {

    @Test
    fun keypadSolutionTest() {
        var numbers: IntArray = intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5)
        var answer = ""
        val LEFT = "left"
        val leftArray = intArrayOf(1, 4, 7)
        val RIGHT = "right"
        val hand = "right"
        val rightArray = intArrayOf(3, 6, 9)
        var leftPosition: Any = "*"
        var rightPosition: Any = "#"


        numbers.forEach {
            when {
                leftArray.contains(it) -> {
                    answer += "L"
                    leftPosition = it
                }
                rightArray.contains(it) -> {
                    answer += "R"
                    rightPosition = it
                }
                else -> {
                    val numLocation = it.convertToLocation()
                    val leftDistance = leftPosition.convertToLocation().distance(numLocation)
                    val rightDistance = rightPosition.convertToLocation().distance(numLocation)
                    when {
                        leftDistance > rightDistance -> {
                            answer += "R"
                            rightPosition = it
                        }
                        leftDistance < rightDistance -> {
                            answer += "L"
                            leftPosition = it
                        }
                        leftDistance == rightDistance -> {
                            when (hand) {
                                LEFT -> {
                                    answer += "L"
                                    leftPosition = it
                                }
                                else -> {
                                    answer += "R"
                                    rightPosition = it
                                }
                            }
                        }
                    }
                }
            }
        }

        println(answer)
    }

    fun Any.convertToLocation(): Pair<Int, Int> {
        return when (this) {
            1 -> Pair(0, 3)
            2 -> Pair(1, 3)
            3 -> Pair(2, 3)
            4 -> Pair(0, 2)
            5 -> Pair(1, 2)
            6 -> Pair(2, 2)
            7 -> Pair(0, 1)
            8 -> Pair(1, 1)
            9 -> Pair(2, 1)
            "*" -> Pair(0, 0)
            0 -> Pair(1, 0)
            "#" -> Pair(2, 0)
            else -> Pair(-1, -1)
        }
    }

    private fun Pair<Int, Int>.distance(pair: Pair<Int, Int>): Int {
        return kotlin.math.abs(this.first - pair.first) + kotlin.math.abs(this.second - pair.second)
    }


    @Test
    fun practiceTestSolutionTest() {
        val answers = intArrayOf(1, 3, 2, 4, 2)
        val firstAnswers = arrayListOf(1, 2, 3, 4, 5)
        val secondAnswers = arrayListOf(2, 1, 2, 3, 2, 4, 2, 5)
        val thirdAnswers = arrayListOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        var firstAnswersCount = 0
        var secondAnswersCount = 0
        var thirdAnswersCount = 0

        answers.forEachIndexed { index, answer ->
            println(firstAnswers[index % firstAnswers.size])
            println(secondAnswers[index % secondAnswers.size])
            println(thirdAnswers[index % thirdAnswers.size])
            println(answers[index])
            if (firstAnswers[index % firstAnswers.size] == answers[index]) {
                firstAnswersCount += 1
            }

            if (secondAnswers[index % secondAnswers.size] == answers[index]) {
                secondAnswersCount += 1
            }

            if (thirdAnswers[index % thirdAnswers.size] == answers[index]) {
                thirdAnswersCount += 1
            }
        }


        val answerList = intArrayOf(firstAnswersCount, secondAnswersCount, thirdAnswersCount)
        println("test")
        val max = answerList.maxOrNull()

        val answer = arrayListOf<Int>()
        if (max == firstAnswersCount) {
            answer.add(1)
        }


        if (max == secondAnswersCount) {
            answer.add(2)
        }

        if (max == thirdAnswersCount) {
            answer.add(3)
        }
        println(answer)
    }

    @Test
    fun summerwintercodingTest() {
        val nums = intArrayOf(1, 2, 7, 6, 4)
        var answer = 0

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        println("Hello Kotlin")

        for (i in 0 until nums.size - 2) {
            for (j in i + 1 until nums.size - 1) {
                for (k in j + 1 until nums.size) {
                    if (isPrime(nums[i] + nums[j] + nums[k])) {
                        answer += 1
                    }
                }
            }
        }
        print(answer)
    }


    fun isPrime(num: Int): Boolean {
        for (i in 2 until num) {
            if (num % i == 0) {
                return false
            }
        }
        return true
    }

    @Test
    fun kakaoblindrecruitmentTest() {
        val new_id = "...!@BaT#*..y.abcdefghijklm"
        var answer: String = ""
        answer = step1(new_id)
        println(answer)
        answer = step2(answer)
        println(answer)
        answer = step3(answer)
        println(answer)
        answer = step4(answer)
        println(answer)
        answer = step5(answer)
        println(answer)
        answer = step6(answer)
        println(answer)
        answer = step7(answer)
        println(answer)
    }

    /**
     * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
     */
    private fun step1(new_id: String): String {
        return new_id.toLowerCase()
    }

    /**
     * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
     */
    private fun step2(new_id: String): String {
//        val charArray = new_id.toCharArray()
        val sb = StringBuffer(new_id)
//        val result = charArray.filter {
//            it in 'a'..'z' || it in '0'..'9' || it == '-' || it == '_' || it == '.'
//        }.toCharArray()
        val result = sb.filter {
            it in 'a'..'z' || it in '0'..'9' || it == '-' || it == '_' || it == '.'
        }
        return result.toString()
    }

    /**
     * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
     */
    private fun step3(new_id: String): String {
        var result = new_id
        while (result.contains("..")) {
            result = result.replace("..", ".")
        }
        return result
    }

    /**
     * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
     */
    private fun step4(new_id: String): String {
        var result = new_id
        result = result.removePrefix(".")
        result = result.removeSuffix(".")
        return result
    }

    /**
     * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
     */
    private fun step5(new_id: String): String {
        return if (new_id.isBlank()) {
            "a"
        } else {
            new_id
        }
    }

    /**
     * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     * 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
     */
    private fun step6(new_id: String): String {
        var result = new_id
        if (result.toCharArray().size > 15) {
            result = result.removeRange(15, result.toCharArray().size)
        }
        return step4(result)
    }

    /**
     * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
     */
    private fun step7(new_id: String): String {
        var result = StringBuffer(new_id)
        if (result.length < 3) {
            while (result.length < 3) {
                result.append(result.last())
            }
        }
        return result.toString()
    }

    @Test
    fun rectangleStarTest() {
        val rectangularStar = Solution()

        assertEquals(
            expected = rectangularStar.solution(arrayOf(5, 3)),
            actual = "*****\n*****\n*****\n"
        )
    }

    @Test
    fun numericstringsandenglishwordsTest() {
        val numericstringsandenglishwords =
            net.soy.algorithm.level1.kakaowinterintern.numericstringsandenglishwords.Solution()

        assertEquals(
            expected = numericstringsandenglishwords.solution("one4seveneight"),
            actual = 147814781478
        )
    }

    @Test
    fun gymsuitTest() {
        val gymsuit = net.soy.algorithm.level1.greedy.gymsuit.Solution()

        assertEquals(
            expected = gymsuit.solution(n = 3, lost = intArrayOf(1, 2), reserve = intArrayOf(2, 3)),
            actual = 2
        )
    }

    @Test
    fun secondWeekTest() {
        val secondWeek = net.soy.algorithm.level1.weeklycodechallenge.secondWeek.Solution()

        assertEquals(
            expected = secondWeek.solution(
                arrayOf(
                    intArrayOf(70, 49, 90),
                    intArrayOf(68, 50, 38),
                    intArrayOf(73, 31, 100)
                )
            ),
            actual = "CFD"
        )
    }

    @Test
    fun hIndexTest() {
        val hIndex = net.soy.algorithm.level2.sort.hIndex.Solution()

        assertEquals(
            expected = hIndex.solution(intArrayOf(3, 0, 6, 1, 5)),
            actual = 3
        )
    }

    @Test
    fun bestAlbumTest() {
        val bestAlbum = net.soy.algorithm.level3.hash.bestAlbum.Solution()

        assertEquals(
            expected = bestAlbum.solution(
                arrayOf("classic", "pop", "classic", "classic", "pop"),
                intArrayOf(500, 600, 150, 800, 2500)
            ),
            actual = intArrayOf(4, 1, 3, 0)
        )
    }

    @Test
    fun nNumbersSpacedByXTest() {
        val nNumbersSpacedByX = net.soy.algorithm.level1.exercise.nNumbersSpacedByX.Solution()

        assertEquals(
            expected = nNumbersSpacedByX.solution(x = -4, n = 2),
            actual = longArrayOf(-4, -8)
        )
    }

    @Test
    fun theTopAndBottomOfTheLotteryTest() {
        val theTopAndBottomOfTheLottery =
            net.soy.algorithm.level1.devMatching2021.theTopAndBottomOfTheLottery.Solution()

        assertEquals(
            expected = theTopAndBottomOfTheLottery.solution(
                lottos = intArrayOf(0, 0, 0, 0, 0, 0),
                win_nums = intArrayOf(38, 19, 20, 40, 15, 25)
            ),
            actual = intArrayOf(1, 6)
        )
    }

    @Test
    fun notIncludedNumTest() {
        val notIncludedNum =
            net.soy.algorithm.level1.monthlycodechallenge.season3.notIncludedNum.Solution()

        assertEquals(
            expected = notIncludedNum.solution(intArrayOf(5,8,4,0,6,7,9)),
            actual = 6
        )
    }

}

