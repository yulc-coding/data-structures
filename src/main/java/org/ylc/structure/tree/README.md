# Tree
* 根：树顶端的节点叫做树的根；
* 路径：从一个节点到另一个节点所经过的节点顺序叫做路径；
* 父节点：除根节点外指向自己的节点称为它的父节点（有且只有一个）；
* 子节点：当前节点指向的节点称为它的子节点（可以有多个）；
* 兄弟节点：拥有相同父节点的节点称为兄弟（siblings）；
* 叶节点：没有子节点的节点称为“叶子节点”，简称“叶节点”（leaf）；
* 子树：每个节点都可以称为是“子树”的根，它和它下面的节点构成了一个子树；
* 层：从根节点到这个节点有多少代；

## 二叉查询树
* 若左子树不空，则左子树上所有结点的值均小于它的根结点的值；
* 若右子树不空，则右子树上所有结点的值均大于它的根结点的值；
* 左、右子树也分别为二叉查询树；
* 没有键值相等的结点；