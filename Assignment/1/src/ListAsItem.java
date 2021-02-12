public class ListAsItem extends GeneralList implements ListItem {
    private String id;
    
    public ListAsItem (String id) {
        this.id = id;
    }

    @Override
    public String getItemId () {
        return this.id;
    }
}
