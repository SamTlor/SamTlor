# Definition for singly-linked list.

class ListNode:
    def __init__(self, value=0, next=None):
        self.value = value
        self.next = next

class LinkedList:
    def __init__(self):
        self.head = None

    def insert(self, newData):
        newNode = ListNode(newData)         #turn the newData into a node

        if(self.head):                      #if there is already data in the linked list
            current = self.head             #set current to be the begginning of the linked list
            while current.next:             #go all the way through the linked list until the list doesn't point anywhere
                current = current.next
            current.next = newNode          #set the last pointer that doesn't point anywere to the newNode
        else:
            self.head = newNode






class Solution:
    def addTwoNumbers(self, l1, l2):

        adder = 0                                   #for the first time the program runs
        fake_ending = ending = ListNode()           #fake ending being equal to ending in the declaration means they equal the same node
        while l1 or l2 or adder:

            if l1 != None:
                adder += l1.value
                l1 = l1.next
            if l2 != None:
                adder += l2.value
                l2 = l2.next
            
            ending.next = ListNode(adder % 10)      #so even after ending.next changes, fake ending still points to the original ending
            adder = 0 + (adder // 10)

            ending = ending.next

        return fake_ending.next                     #so this actually returns the original ending.next



#only based on ListNode
if __name__ == '__main__':
    first = [2,4,3]
    second = [5,6,4]

    real_l1 = l1 = ListNode(first[0])
    real_l2 = l2 = ListNode(second[0])

    for i, j in zip(first, second):
        l1.next = ListNode(i)
        l2.next = ListNode(j)

        l1 = l1.next
        l2 = l2.next



    thing = Solution()
    var = thing.addTwoNumbers(real_l1, real_l2)

    while var.next != None:
        print(var.next.value)
        var = var.next