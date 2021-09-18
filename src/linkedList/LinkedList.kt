package linkedList

import node.Node

/**
 * In src, create a new folder linkedList and  file LinkedList.kt. Add the following to the file:
 */

class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    /**
     * append operations
     * The next operation you’ll look at is :append() .
     * This adds a value at the end of the list,which is known as tail-end insertion.
     * @param value: T
     * @return LinkedList<T>
     */

    fun append(value: T):LinkedList<T>{
        /**
         * 1. Like before, if the list is empty, you’ll need to update both head and tail to the
            new node. Since append on an empty list is functionally identical to push , you
            invoke push to do the work for you.
         * 2. In all other cases, you create a new node after the current tail node. tail will
            never be null here because you’ve already handled the case where the list is
            empty in the if statement.
         * 3. Since this is tail-end insertion, your new node is also the tail of the list.
         */
        if (isEmpty()){
            push(value)
            return this
        }
        tail?.next = Node(value = value)

        tail = tail?.next

        size ++
        return this
    }

    /**
     * insert opera6ons
        The third and final operation for adding values is insert(afterNode: Node<T>) .
        This operation inserts a value at a particular place in the list and requires two steps:
        1. Finding a particular node in the list.
        2. Inserting the new node after that node.
     *
     */


    fun nodeAt(index: Int): Node<T>? {
        /**
         * nodeAt() tries to retrieve a node in the list based on the given index. Since you can
        only access the nodes of the list from the head node, you’ll have to make iterative
        traversals. Here’s the play-by-play:
        1. You create a new reference to head and keep track of the current number of
        traversals.
        2. Using a while loop, you move the reference down the list until you reach the
        desired index. Empty lists or out-of-bounds indexes will result in a null return
        value.
         */
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index){
            currentNode = currentNode.next

            currentIndex++
        }
        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T>{
        /**
         * 1. In the case where this method is called with the tail node, you call the
        functionally equivalent append method. This takes care of updating tail .
        2. Otherwise, you create a new node and link its next property to the next node of
        the list.
        3. You reassign the next value of the specified node to link it to the new node that
        you just created.
         */
        if (tail ==afterNode){
            append(value)
            return tail!!
        }
        val newNode = Node(value = value, next = afterNode.next)

        afterNode.next = newNode
        size++
        return newNode
    }
    private fun isEmpty(): Boolean{
        return size == 0
    }

    /**
     * push operations
     * Adding a value at the front of the list is known as a push operation.
     * This is also known as head-first insertion.
     * @param value T
     *
     * @return LinkedList<T>
     */

    fun push(value: T): LinkedList<T>{
        /**
         * In the case in which you’re pushing into an empty list,
         * the new node is both the head and tail of the list.
         * Since the list now has a new node, you increment the value of size .
         */
        head = Node(value = value, next = head)
        if (tail == null){
            tail = head
        }
        size++

        return this
    }

    /**
     * pop operations
        Removing a value at the front of the list is often referred to as pop.
        This operation is almost as simple as push() ,
        so dive right in.
     */
    /**
     * pop() returns the value that was removed from the list.
     * This value is optional since it’s possible that the list is empty.
     * By moving the head down a node, you’ve effectively removed the first node of the list.
     * The garbage collector will remove the old node from memory once the method
     * finishes since there will be no more references attached to it. If the list becomes
     * empty, you set tail to null as well.
     */
    fun pop(): T? {
        if (isEmpty()) size --
        val result = head?.value
        head = head?.next
        if (isEmpty()){
            tail = null
        }
        return result
    }

    fun removeLast(): T?{
        /**
         * Here’s what’s happening:
            1. If head is null , there’s nothing to remove, so you return null .
            2. If the list only consists of one node, removeLast is functionally equivalent to
            pop . Since pop will handle updating the head and tail references, you can
            delegate this work to the pop function.
            3. At this point, you know that you’ll be removing a node, so you update the size of
            the list accordingly.
            4. You keep searching for the next node until current.next is null . This signifies
            that current is the last node of the list.
            5. Since current is the last node, you disconnect it using the prev.next reference.
            You also make sure to update the tail reference.
         */
        val head = head ?: return null
        if (head.next == null) return pop()

        size --

        var prev = head
        var current = head

        var next = current.next

        while (next != null){
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        tail = prev

        return current.value

    }

    /**
     * The final remove operation is removing a node at a particular point in the list.
     * This is achieved much like insert() .
     * You’ll first find the node immediately before the node
     * you wish to remove and then unlink it.
     */

    fun removeAfter(node: Node<T>): T? {
        var result = node.next?.value
        if (node.next == tail){
            tail = node
        }
        if(node.next != null){
            size --
        }

        node.next = node.next?.next
        return result
    }


    override fun toString(): String {
        return if (isEmpty()){
            "Empty List"
        }else{
            head.toString()
        }
    }
}