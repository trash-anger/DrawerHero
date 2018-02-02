package re.uyt.drawerhero;

/**
 * Created by Florian on 02/02/2018.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DocumentsAdapter extends RecyclerView.Adapter<DocumentsAdapter.MyViewHolder> {

    private List<Document> documentsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView page, creationdate, document;

        public MyViewHolder(View view) {
            super(view);
            page = (TextView) view.findViewById(R.id.page);
            document = (TextView) view.findViewById(R.id.document);
            creationdate = (TextView) view.findViewById(R.id.creationdate);
        }
    }


    public DocumentsAdapter(List<Document> documentsList) {
        this.documentsList = documentsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.document_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Document document = documentsList.get(position);
        holder.page.setText(document.getPage());
        holder.document.setText(document.getDocument());
        holder.creationdate.setText(document.getCreationDate());
    }

    @Override
    public int getItemCount() {
        return documentsList.size();
    }
}