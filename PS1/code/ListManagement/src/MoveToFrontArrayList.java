/**
 * MoveToFrontArrayList
 * Description: Modified array-based extension of ArrayList
 * that moves item to front of the list when item is found
 * CS2040
 * 
 * You need to create a constructor and implement search.
 */


/**
 * 
 */
public class MoveToFrontArrayList extends ArrayList {

    MoveToFrontArrayList(int length) {
        super(length);
    }

    // Problem 1.1
    @Override
    public boolean search(int key) {
        /*super.add();*/

        // creating a new arrayList object
        ArrayList result = new ArrayList(m_length);

        // search for key
        for (int findKey = 0; findKey <= m_max; findKey++) {

            // if found, move to front
            if (m_list[findKey] == key) {
                result.add(m_list[findKey]);

                for (int otherKey = 0; otherKey <= m_max; otherKey++) {
                    // if not key, add to result
                    if (m_list[otherKey] != key) {
                        result.add(m_list[otherKey]);
                    }
                }
                // update new m_list
                m_list = result.m_list;
                return true;
            }
        }
        // if not found, false
        return false;
    }

}