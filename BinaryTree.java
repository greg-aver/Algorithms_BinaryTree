    public ArrayList<BSTNode<T>> DeepAllNodes(int type_order) {
        ArrayList<BSTNode<T>> listAllNodes = new ArrayList<>();
        return switch (type_order) {
            case 0 -> inOrderRecursiveDeepAllNode(listAllNodes, getRoot());
            case 1 -> postOrderRecursiveDeepAllNode(listAllNodes, getRoot());
            case 2 -> preOrderRecursiveDeepAllNode(listAllNodes, getRoot());
            default -> listAllNodes;
        };
    }

    private ArrayList<BSTNode<T>> inOrderRecursiveDeepAllNode(ArrayList<BSTNode<T>> listAllNodes, BSTNode<T> rootNode) {
        if (rootNode.getLeftChild() != null) {
            inOrderRecursiveDeepAllNode(listAllNodes, rootNode.getLeftChild());
        }
        listAllNodes.add(rootNode);
        if (rootNode.getRightChild() != null) {
            inOrderRecursiveDeepAllNode(listAllNodes, rootNode.getRightChild());
        }
        return listAllNodes;
    }

    private ArrayList<BSTNode<T>> postOrderRecursiveDeepAllNode(ArrayList<BSTNode<T>> listAllNodes, BSTNode<T> rootNode) {
        if (rootNode.getLeftChild() != null) {
            postOrderRecursiveDeepAllNode(listAllNodes, rootNode.getLeftChild());
        }
        if (rootNode.getRightChild() != null) {
            postOrderRecursiveDeepAllNode(listAllNodes, rootNode.getRightChild());
        }
        listAllNodes.add(rootNode);
        return listAllNodes;
    }

    private ArrayList<BSTNode<T>> preOrderRecursiveDeepAllNode(ArrayList<BSTNode<T>> listAllNodes, BSTNode<T> rootNode) {
        listAllNodes.add(rootNode);
        if (rootNode.getLeftChild() != null) {
            preOrderRecursiveDeepAllNode(listAllNodes, rootNode.getLeftChild());
        }
        if (rootNode.getRightChild() != null) {
            preOrderRecursiveDeepAllNode(listAllNodes, rootNode.getRightChild());
        }
        return listAllNodes;
    }

    public ArrayList<BSTNode<T>> WileAllNodes() {
        ArrayList<BSTNode<T>> listAllNodes = new ArrayList<>();
        LinkedList<BSTNode<T>> queue = new LinkedList<>();
        BSTNode<T> node = getRoot();
        do {
            listAllNodes.add(node);
            if (node.getLeftChild() != null) {
                queue.add(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                queue.add(node.getRightChild());
            }
            if (!queue.isEmpty()) {
                node = queue.poll();
            }
        } while (!queue.isEmpty() || !listAllNodes.contains(node));
        return listAllNodes;
    }
