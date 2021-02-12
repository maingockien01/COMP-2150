
//----------------------------------------------------
// CLASS			: 	COMP 2150
//
// AUTHOR			: 	Kien Mai
//
// REMARKS			: 	
//
//-----------------------------------------------------
public class DocumentImp implements Document {
    //read-only / cannot write over
    private String title;
    
    //Change-able
    private String content;

    public DocumentImp (String title) {
        assert (title != null);

        this.title = title;
        this.content = "";
    }

    public DocumentImp (String title, String content) {
        assert(title != null);
        assert(content != null);

        this.title = title;
        this.content = content;
    }

    @Override
    public String getTitle () {
        return this.title;
    }

    @Override
    public String getContent () {
        return this.content;
    }


    @Override
    public boolean edit (int line, String newLine) {
        if (isDocumentEmpty () || line < 0) {
            return false;
        }
        String[] lines = content.split("\n", -1);
        if (line >= lines.length) {
            return false;
        }

        lines[line] = newLine;

        this.content = assemble(lines);

        return true;
    }

    @Override
    public boolean append (String newLine) {
        if (isDocumentEmpty ()) {
            this.content = newLine;
        } else {
            StringBuilder builder = new StringBuilder ();
            builder.append(this.content);
            builder.append(newLine);

            this.content = builder.toString ();
        }
        
        return true;
    }

    @Override
    public boolean deleteLine (int line) {
        if (isDocumentEmpty () || line < 0) {
            return false;
        }

        String[] lines = content.split("\n", -1);
        
        if (line >= lines.length ) {
            return false;
        }

        StringBuilder builder = new StringBuilder ();

        if (line != 0) {
            builder.append(lines[0]);
        }

        for (int i = 1; i < lines.length; i ++) {
            if (i != line) {
            	if (line != 0) {
            		builder.append("\n");
            	}
                builder.append(lines[i]);
            }
        }

        this.content = builder.toString ();
        
        return true;
    }

    @Override
    public boolean equals (Document other) {
        return other.getTitle().equals(this.title);
    }

    @Override
    public void setContent (String content) {
        this.content = content;
    }

    private boolean isDocumentEmpty () {
        return this.content.equals("");
    }

    private String assemble (String[] lines) {
        if (lines == null || lines.length <= 0) {
                return "";
        }

        StringBuilder builder = new StringBuilder (lines[0]);


        for (int i = 1; i < lines.length; i ++) {
            builder.append("\n");
            builder.append(lines[i]);
        }

        return builder.toString ();
    }

    @Override
    public String getItemId () {
        return this.title;
    }

}
