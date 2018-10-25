import java.util.Iterator;

/**
 * This class extends QuestionTreeBase for students to implement the buildTree
 * and findQuery methods.
 *
 * @author
 */
public class QuestionTree extends QuestionTreeBase {

	/**
	 * This method builds the tree of objects.
	 *
	 * @param objects an array of QuestionObjects
	 */
	@Override
	public void buildTree(java.util.ArrayList<QuestionObject> objects) {
		// Implement this method for Problem 1.1
		// sort objects according to number of properties
		java.util.Collections.sort(objects);
		// create empty root
		// iterate through properties of objects
		TreeNode<String> currNode = m_root;
		for (int i = 0; i < objects.size(); ++i) {
			Iterator<String> properties = objects.get(i).propertyIterator();
			// array of properties
//			String propArr[] = objects.get(i).toString().split("\n")[1].split(": ")[1].split(",");
			// ensure currNode not leaf
			// empty root, make new root
			if (m_root == null) {
				m_root = new TreeNode(properties.next());
			}
			currNode = m_root;
			while (properties.hasNext()) {
				// if object contains properties in current node grow right
				if (objects.get(i).containsProperty(currNode.getValue())) {
					// there are properties to add
					// right child empty
					if (currNode.getRight() == null) {
						TreeNode<String> newNode = new TreeNode(properties.next());
						currNode.setRight(newNode);
						newNode.setParent(currNode);
						currNode = newNode;
						} else {
							// go to right child
							currNode = currNode.getRight();
						}
					} else {
						// if property not found in tree
						// if object does not contain property in current node
						if (currNode.getLeft() == null) {
							TreeNode<String> newNode = new TreeNode(properties.next());
							if (currNode != m_root) {
								if (currNode.getParent().getValue().equals(newNode.getValue())) {
									newNode = new TreeNode(properties.next());
								}
							}
							currNode.setLeft(newNode);
							newNode.setParent(currNode);
							currNode = newNode;

							} else {
							// go to the left
								currNode = currNode.getLeft();
							}
					}
			}
			if (objects.get(i).containsProperty(currNode.getValue())) {
				// no more properties to add
				LeafNode newLeaf = new LeafNode(objects.get(i).getName(), objects.get(i));
				currNode.setRight(newLeaf);
				newLeaf.setParent(currNode);
			} else {
				// no more properties to add
				LeafNode newLeaf = new LeafNode(objects.get(i).getName(), objects.get(i));
				currNode.setLeft(newLeaf);
				newLeaf.setParent(currNode);
			}
		}
	}
// Let n be the count at the root and assume n >1. Then there exists a node
// in the tree such that n/3 count(v) <= 2n/3
	/**
	 * This method calculates the next question to ask in the game.
	 * It finds a node in the tree that has at least n/3 objects as descendants, and
	 * at most 2n/3 objects as descendants, where n is the total number of objects in
	 * the tree.
	 *
	 * @return the next query that will eliminate at least n/3 objects in the tree
	 */
	@Override
	public Query findQuery(){
		// Implement this method for Problem 1.2
		TreeNode currNode = m_root;
		int n = countObjects();
		int countV = countObjects(currNode);
		Query chosenQ = null;
		// must have questions left to ask
		if (!currNode.isLeaf()) {
			while (!currNode.isLeaf()) {
				// check descedents of root n/3 < count v <= 2*n/3
				if (n/3 < countV && countV <= 2*n/3) {
					chosenQ = constructQuery(currNode);
				} else {
					int countRight = countObjects(currNode.getRight());
					int countLeft = countObjects(currNode.getLeft());
					// traverse right
					if (countRight > countLeft) {
						currNode = currNode.getRight();
					} else {
						// traverse left
						currNode = currNode.getLeft();
					}
				}
			}
		}
		return chosenQ;
	}
}
// to find answer you need to keep triming the tree and removing until you getOneObject
