package re.uyt.drawerhero;

/**
 * Created by Florian on 02/02/2018.
 */

public class Document {
    private String page, document, creationdate;

    public Document() {
    }

    public Document(String page, String document, String creationdate) {
        this.page = page;
        this.document = document;
        this.creationdate = creationdate;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String name) {
        this.page = name;
    }

    public String getCreationDate() {
        return creationdate;
    }

    public void setCreationDate(String creationdate) {
        this.creationdate = creationdate;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
