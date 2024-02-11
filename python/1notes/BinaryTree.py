import math

class Node:
    def __init__(self, value) -> None:
        self.left = None                                #left child
        self.right = None                               #right child
        self.value = value                              #this node's value

    def insert(self, value):
        if self.value:                                  #if the value has already been set
            if value is None:
                return
            if value < self.value:                      #if the value to insert is less than the current node's value
                if self.left is None:                   #if the current node doesn't have a left child
                    self.left = Node(value)             #set the left child 
                else:
                    self.left.insert(value)             #otherwise make the left child the current node


            elif value > self.value:                    #if the value to insert is greater than the current node's value
                if self.right is None:                  #if the current node doesn't have a right child
                    self.right = Node(value)            #set the right child
                else:
                    self.right.insert(value)            #otherwise make the right child the current node


        else:                                           #if the value hasn't been set
            self.value = value                          #set it

#traversals
    def LevelorderTraversal(self, root):
        visited = [root]                            #all of the nodes the progam has been to
        ending = []                                 #final return array

        while visited:
            ending.append(visited.pop().value)

            if root.left is not None:               #if the child is not empty add it to the beginning of the to_visit queue
                visited = [root.left] + visited
            if root.right is not None:
                visited = [root.right] + visited
            try:                                    #if the visited array is not empty
                root = visited[-1]                  #set root to be the next item from the end of the queue
            except:                                 #if that fails break
                break
        
        return ending

    def PreorderTraversal(self, root):
        res = []
        if root:
            res.append(root.value)
            res = res + self.PreorderTraversal(root.left)
            res = res + self.PreorderTraversal(root.right)
        return res

    def InorderTraversal(self, root):
        res = []
        if root:
            res = res + self.InorderTraversal(root.left)
            res.append(root.value)
            res = res + self.InorderTraversal(root.right)
        return res

    def PostorderTraversal(self, root):
        res = []
        if root:
            res = res + self.PostorderTraversal(root.left)
            res = res + self.PostorderTraversal(root.right)
            res.append(root.value)
        return res

    def maxAncestorDiff(self, root, curMin = math.inf, curMax = -math.inf):
        if not root:
            return curMax - curMin
        
        curMin = min(curMin , root.value)
        curMax = max(curMax, root.value)

        return max(self.maxAncestorDiff(root.left,  curMin, curMax), self.maxAncestorDiff(root.right, curMin, curMax))
        
toInsert = [2,7,1,3,None,None,None,None,None, None, 5]

root = Node(4)
for i in toInsert:
    root.insert(i)


print("Level order: ", root.LevelorderTraversal(root))
print("Preorder: ", root.PreorderTraversal(root))
print("Inorder: ", root.InorderTraversal(root))
print("Postorder: ", root.PostorderTraversal(root), "\n")