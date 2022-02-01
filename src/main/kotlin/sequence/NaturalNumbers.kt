package sequence

/**
 * @Author Heli
 */
fun main() {
    // sequence 는 함수를 한개 원소씩 순차적으로 실행하여 조건에 맞으면 그대로 종료
    val naturalNumbers = generateSequence(1) { it + 1 } //0부터 시작

    // 여기까지도 아무것도 실행안됨
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }

    // sum() 은 최종연산
    println(numbersTo100.sum())
}
