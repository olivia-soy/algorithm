package net.soy.algorithm.codingTest.test2

/**
 * Algorithm
 * mobility
 * @author leesoyoung
 * @since 2022/01/21
 */

class RepositoryImpl(): Repository<Student>{
    override fun get(): Iterable<Student> {
        return listOf(Student(id = 1,name = "jacob", subscribedCourse = listOf(Course(id = 1, name = "Maths",isPaid = false), Course(id = 2, name = "Arts",isPaid = true))),
            Student(id = 1,name = "jacob", subscribedCourse = listOf(Course(id = 1, name = "History",isPaid = true), Course(id = 2, name = "Biology",isPaid = true))),
            Student(id = 1,name = "jacob", subscribedCourse = listOf(Course(id = 1, name = "Physics",isPaid = true), Course(id = 2, name = "History",isPaid = true))))
    }
}