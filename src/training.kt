import linkedList.LinkedList
import node.Node

fun main(){

//    fun multiplicationBoard(size: Int){
//        for (number in 1..size){
//            print(" | ")
//            for (otherNumber in 1..size){
//                print("$number x $otherNumber = ${number * otherNumber} |")
//            }
//            println()
//        }
//    }

//    multiplicationBoard(10)
//    fun sumFromOn(n: Int): Int = (1..n).reduce { sum, element -> sum + element }

//    println(sumFromOn(10))
//        val node1 = Node(value = 1)
//        val node2 = Node(value = 2)
//        val node3 = Node(value = 3)
//        node1.next = node2
//        node2.next = node3
//        println(node1)









    val list1 = LinkedList<Int>()
    val list = LinkedList<Int>()

    list1.push(3).push(2).push(1)


    list.append(1).append(2).append(3)

//    println(list)
//
//    println("Before inserting: $list1")
//    var middleNode = list1.nodeAt(1)!!
//
//    for (i in 1..3){
//        middleNode = list1.insert(-1 * i, middleNode)
//
//    }
//    println("After inserting: $list1")


//    println("Before popping list: $list1")
////
//    val poppedValue = list1.pop()
//    println("After popping list: $list1")
//    println("Popped value: $poppedValue")


//    println("Before removing last node: $list1")
//    val removedValue = list1.removeLast()
//
//    println("After removing last node: $list1")
//    println("Removed value: $removedValue")

    println("Before removing at particular index: $list1")
    val index = 1
    val node = list1.nodeAt(index - 1)!!
    val removedValue = list1.removeAfter(node)

    println("After removing at index $index: $list1")
    println("Removed value: $removedValue")


}

