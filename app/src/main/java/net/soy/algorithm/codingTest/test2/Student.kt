package net.soy.algorithm.codingTest.test2

/**
 * Algorithm
 * mobility
 * @author leesoyoung
 * @since 2022/01/21
 */

typealias  Id = Int

data class Student(val id: Id? = null, val name: String? = null, val subscribedCourse: List<Course>)
data class Course(val id: Id? = null, val name: String, val isPaid: Boolean)
