package net.soy.algorithm.codingTest.test2

/**
 * Algorithm
 * mobility
 * @author LEESOYOUNG
 * @since 2022/01/21
 */
class University(private val repository: Repository<Student>) {
    fun getPaidCoursesWithTheNumbersOfSubscribedStudents(coursesCount:Int): Map<Course,Int> {
        val countedStudentList = repository.get().take(coursesCount)

        val subscribedCourseList = arrayListOf<Course>()
        countedStudentList.map { student ->
            student.subscribedCourse
        }.forEach {list ->
            subscribedCourseList.addAll(list.filter { it.isPaid })
        }

        return subscribedCourseList.groupBy { it.name }.map {
            mapOf( Course(name = it.key, isPaid = true) to it.value.size)
        }[coursesCount]
    }
}