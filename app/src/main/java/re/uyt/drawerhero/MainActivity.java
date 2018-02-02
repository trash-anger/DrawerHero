package re.uyt.drawerhero;

import android.content.DialogInterface;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Menu;

import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Document> documentList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DocumentsAdapter mAdapter;
    private FloatingActionButton fab;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "opening the new item menu", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new DocumentsAdapter(documentList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // set the adapter
        recyclerView.setAdapter(mAdapter);

        prepareDocumentData();


        //add new item
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inflater = MainActivity.this.getLayoutInflater();
                View content = inflater.inflate(R.layout.edit_item, null);
                final EditText setDocument = (EditText) content.findViewById(R.id.editDocument);
                final EditText setPage = (EditText) content.findViewById(R.id.editPage);
                final EditText setCreationDate = (EditText) content.findViewById(R.id.editCreationDate);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(content)
                        .setTitle("Add document")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Document document = new Document();
                                //book.setId(RealmController.getInstance().getBooks().size() + 1);
                                //document.setId(RealmController.getInstance().getBooks().size() + System.currentTimeMillis());
                                document.setDocument(setDocument.getText().toString());
                                document.setPage(setPage.getText().toString());
                                document.setCreationDate(setCreationDate.getText().toString());

                                if (setDocument.getText() == null || setDocument.getText().toString().equals("") || setDocument .getText().toString().equals(" ")) {
                                    Toast.makeText(MainActivity.this, "Entry not saved, missing title", Toast.LENGTH_SHORT).show();
                                } else {
                                    // Persist your data easily
                                    /*realm.beginTransaction();
                                    realm.copyToRealm(book);
                                    realm.commitTransaction();

                                    adapter.notifyDataSetChanged();

                                    // scroll the recycler view to bottom
                                    recycler.scrollToPosition(RealmController.getInstance().getBooks().size() - 1);*/
                                }
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void prepareDocumentData() {
        Document document = new Document("Colvert", "Dessin de canards", "1 jan 2015");
        documentList.add(document);

        document = new Document("Dendrocygne", "Dessin de canards", "23 feb 2015");
        documentList.add(document);

        document = new Document("Grisly", "Dessin d'ours", "16 jun 2015");
        documentList.add(document);

        document = new Document("Ours blanc", "Dessin d'ours", "31 aug 2015");
        documentList.add(document);

        document = new Document("Dauphin commun", "Dessin de dauphin", "23 sep 2015");
        documentList.add(document);

        document = new Document("Thon", "Dessin de poisson", "19 nov 2015");
        documentList.add(document);

        document = new Document("Bar", "Dessin de poisson", "14 jan 2009");
        documentList.add(document);

        document = new Document("Saumon", "Dessin de poisson", "11 mar 2009");
        documentList.add(document);

        document = new Document("Combatant", "Dessin de poisson", "31 jan 2014");
        documentList.add(document);

        document = new Document("Java", "Dessin de monstre qui fait peur", "28 mar 2008");
        documentList.add(document);

        document = new Document("T-rex", "Dessin de dinosaure", "15 mar 1986");
        documentList.add(document);

        document = new Document("Diplodocus", "Dessin de dinosaure", "16 jun 2000");
        documentList.add(document);

        document = new Document("Berger allemand", "Dessin de chien", "8 dec 1985");
        documentList.add(document);

        document = new Document("Teckel", "Dessin de chien", "3 dec 1981");
        documentList.add(document);

        document = new Document("Persan", "Dessin de chat", "17 jan 1965");
        documentList.add(document);

        document = new Document("De goutière", "Dessin de chat", "24 dec 2014");
        documentList.add(document);

        mAdapter.notifyDataSetChanged();
    }
}