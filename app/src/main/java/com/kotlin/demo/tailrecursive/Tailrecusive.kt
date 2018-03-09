package com.kotlin.demo.tailrecursive

/**
 * author： Created by shiming on 2018/3/9 10:13
 * mailbox：lamshiming@sina.com
 */
class Tailrecusive{
     init {
//         findListNode()
         val MAX=100
         val listNode = ListNode(0)
         println("old listNode=="+listNode.hashCode())
         var p=listNode
         println("old p=="+p.hashCode())
         if (p==listNode){
             println("是一个对象不")
         }
         for (i in 1..MAX){
             p.next = ListNode(i)
             p=p.next!!
             println("循环了哦 "+p)
         }
         println(p)  //ListNode(value=10, next=null)
         println("new listNode=="+listNode.hashCode())
         println("new p=="+p.hashCode())
         //  这就是结构
         //ListNode(value=0, next=ListNode(value=1,
         // next=ListNode(value=2, next=ListNode(value=3,
         // next=ListNode(value=4, next=ListNode(value=5,
         // next=ListNode(value=6, next=ListNode(value=7,
         // next=ListNode(value=8, next=ListNode(value=9,
         // next=ListNode(value=10, next=null)))))))))))
         println("===="+listNode)
         println(findListNode(listNode,MAX-2)?.value)

         println(findListNode1(listNode,MAX-2)?.value)
     }
}
data class ListNode(val value:Int, var next:ListNode?=null)
//是尾递归 加这个 tailrec关键字 尾递归优化 提醒编译器 尾递归优化 ，感觉不加这个关键字的话
//程序没有很好的进行了
tailrec fun findListNode(head:ListNode?,value: Int): ListNode? {
    head?:return null
    println("这个方法我自己觉得 能调用" + head.value+"===$value")
    if (head.value==value)return head
    return findListNode(head.next,value)
}
 fun findListNode1(head:ListNode?,value: Int): ListNode? {
    head?:return null
    println("这个方法我自己觉得 能调用" + head.value+"===$value")
    if (head.value==value)return head
    return findListNode1(head.next,value)
}
//不是 尾递归
fun factorial(n:Long): Long {
    return n* factorial(n-1)
}

data class TreeNode(val value: Int){
    val left :TreeNode?=null
    val right :TreeNode?=null
}
//这不是 尾递归  tailrec
 fun findTreeListNode(root:TreeNode?,value: Int): TreeNode? {
    root?:return null
    if (root.value ==  value) return root
    return findTreeListNode(root.left,value)?:return  findTreeListNode(root.right,value)
}