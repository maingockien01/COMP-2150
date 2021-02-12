//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	general list - implementation of List
// @responsibility		
//
//-----------------------------------------------------

public class GeneralList implements List {
	private ListNode head;

	private ListItem foundTemp;
	private String idTemp;

	/**
	 * 
	 */
	public GeneralList() {
		head = null;
	}

	@Override
	public boolean addItem(ListItem item) {
		assert (item != null);
		if (isThereItem(item.getItemId())) {
			return false;
		}
		
		ListNode node = new OrderedListNode (item);
		
		if (head == null) {
			head = node;
		} else {
            ListNode temp = head;
            
            while(temp.getNext () != null) {
            	temp = temp.getNext();
            }
            
            temp.setNext(node);

        }
		

		return true;
	}

	@Override
	public ListItem getItem(String itemId) {
        if ((foundTemp != null && idTemp.equals(itemId)) || isThereItem (itemId)) {
            return foundTemp;
        };
		return null;
	}

	@Override
	public boolean isThereItem(String itemId) {
        ListNode temp = head;
        if (head == null) {
            return false;
        };

        while (temp != null) {
            ListItem tempItem = temp.getItem ();
            String tempId = tempItem.getItemId ();

            if (tempId.equals (itemId)) {
                foundTemp = temp.getItem();
                idTemp = tempId;
                
                return true;
            }
            
            temp = temp.getNext();
        }

		return false;
	}

    @Override
    public String toString () {
        StringBuilder builder = new StringBuilder ();
        ListNode temp = head;
        while (temp != null) {
            ListItem item = temp.getItem ();
            builder.append(item.toString ());
            builder.append("\n----------\n");

            temp = temp.getNext ();
        }

        return builder.toString ();
    }
}

class OrderedListNode implements ListNode {
	private ListItem item;
	private ListNode next;

	public OrderedListNode(ListItem item) {
		this.item = item;
	}


	@Override
	public ListItem getItem() {
		return this.item;
	}

	@Override
	public ListNode getNext() {
		return this.next;
	}

	@Override
	public void setNext(ListNode next) {
		this.next = next;
	}
}
