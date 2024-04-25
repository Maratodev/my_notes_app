package com.maratodev.notesapp;

import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View$OnClickListener;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import android.widget.Toast;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;
import android.content.Context;
import android.view.View;
import android.content.DialogInterface;
import java.util.List;
import kotlin.Metadata;
import androidx.recyclerview.widget.RecyclerView$Adapter;

@Metadata(d1 = { "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0014\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018" }, d2 = { "Lcom/maratodev/notesapp/NotesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/maratodev/notesapp/NotesAdapter$NoteViewHolder;", "notes", "", "Lcom/maratodev/notesapp/Note;", "context", "Landroid/content/Context;", "(Ljava/util/List;Landroid/content/Context;)V", "db", "Lcom/maratodev/notesapp/NotesDatabaseHelper;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshData", "newNotes", "NoteViewHolder", "app_debug" }, k = 1, mv = { 1, 8, 0 }, xi = 48)
public final class NotesAdapter extends RecyclerView$Adapter<NoteViewHolder>
{
    private final NotesDatabaseHelper db;
    private List<Note> notes;
    
    public NotesAdapter(final List<Note> notes, final Context context) {
        Intrinsics.checkNotNullParameter((Object)notes, "notes");
        Intrinsics.checkNotNullParameter((Object)context, "context");
        this.notes = notes;
        this.db = new NotesDatabaseHelper(context);
    }
    
    private static final void onBindViewHolder$lambda$1(final NoteViewHolder noteViewHolder, final Note note, final View view) {
        Intrinsics.checkNotNullParameter((Object)noteViewHolder, "$holder");
        Intrinsics.checkNotNullParameter((Object)note, "$note");
        final Intent intent = new Intent(noteViewHolder.itemView.getContext(), (Class)ViewNoteActivity.class);
        intent.putExtra("note_id", note.getId());
        noteViewHolder.itemView.getContext().startActivity(intent);
    }
    
    private static final void onBindViewHolder$lambda$3(final NoteViewHolder noteViewHolder, final NotesAdapter notesAdapter, final Note note, final View view) {
        Intrinsics.checkNotNullParameter((Object)noteViewHolder, "$holder");
        Intrinsics.checkNotNullParameter((Object)notesAdapter, "this$0");
        Intrinsics.checkNotNullParameter((Object)note, "$note");
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(noteViewHolder.itemView.getContext());
        alertDialog$Builder.setTitle((CharSequence)"Delete note?");
        alertDialog$Builder.setIcon(R.drawable.warning);
        alertDialog$Builder.setPositiveButton((CharSequence)"Yes", (DialogInterface$OnClickListener)new NotesAdapter$$ExternalSyntheticLambda2(notesAdapter, note, noteViewHolder));
        alertDialog$Builder.setNegativeButton((CharSequence)"No", (DialogInterface$OnClickListener)null);
        alertDialog$Builder.show();
    }
    
    private static final void onBindViewHolder$lambda$3$lambda$2(final NotesAdapter notesAdapter, final Note note, final NoteViewHolder noteViewHolder, final DialogInterface dialogInterface, final int n) {
        Intrinsics.checkNotNullParameter((Object)notesAdapter, "this$0");
        Intrinsics.checkNotNullParameter((Object)note, "$note");
        Intrinsics.checkNotNullParameter((Object)noteViewHolder, "$holder");
        notesAdapter.db.deleteNote(note.getId());
        notesAdapter.refreshData(notesAdapter.db.getAllNotes());
        Toast.makeText(noteViewHolder.itemView.getContext(), (CharSequence)"Note Deleted", 0).show();
    }
    
    public int getItemCount() {
        return this.notes.size();
    }
    
    public void onBindViewHolder(final NoteViewHolder noteViewHolder, final int n) {
        Intrinsics.checkNotNullParameter((Object)noteViewHolder, "holder");
        final Note note = (Note)this.notes.get(n);
        noteViewHolder.getTitleTextView().setText((CharSequence)note.getTitle());
        noteViewHolder.getContentTextView().setText((CharSequence)note.getContent());
        noteViewHolder.itemView.setOnClickListener((View$OnClickListener)new NotesAdapter$$ExternalSyntheticLambda0(noteViewHolder, note));
        noteViewHolder.getMoreButton().setOnClickListener((View$OnClickListener)new NotesAdapter$$ExternalSyntheticLambda1(noteViewHolder, this, note));
    }
    
    public NoteViewHolder onCreateViewHolder(final ViewGroup viewGroup, final int n) {
        Intrinsics.checkNotNullParameter((Object)viewGroup, "parent");
        final View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.notes_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue((Object)inflate, "view");
        return new NoteViewHolder(inflate);
    }
    
    public final void refreshData(final List<Note> notes) {
        Intrinsics.checkNotNullParameter((Object)notes, "newNotes");
        this.notes = notes;
        this.notifyDataSetChanged();
    }
    
    @Metadata(d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f" }, d2 = { "Lcom/maratodev/notesapp/NotesAdapter$NoteViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "contentTextView", "Landroid/widget/TextView;", "getContentTextView", "()Landroid/widget/TextView;", "moreButton", "Landroid/widget/ImageView;", "getMoreButton", "()Landroid/widget/ImageView;", "titleTextView", "getTitleTextView", "app_debug" }, k = 1, mv = { 1, 8, 0 }, xi = 48)
    public static final class NoteViewHolder extends RecyclerView$ViewHolder
    {
        private final TextView contentTextView;
        private final ImageView moreButton;
        private final TextView titleTextView;
        
        public NoteViewHolder(View viewById) {
            Intrinsics.checkNotNullParameter((Object)viewById, "itemView");
            super(viewById);
            final View viewById2 = viewById.findViewById(R.id.titleTextView);
            Intrinsics.checkNotNullExpressionValue((Object)viewById2, "itemView.findViewById(R.id.titleTextView)");
            this.titleTextView = (TextView)viewById2;
            final View viewById3 = viewById.findViewById(R.id.contentTextView);
            Intrinsics.checkNotNullExpressionValue((Object)viewById3, "itemView.findViewById(R.id.contentTextView)");
            this.contentTextView = (TextView)viewById3;
            viewById = viewById.findViewById(R.id.moreButton);
            Intrinsics.checkNotNullExpressionValue((Object)viewById, "itemView.findViewById(R.id.moreButton)");
            this.moreButton = (ImageView)viewById;
        }
        
        public final TextView getContentTextView() {
            return this.contentTextView;
        }
        
        public final ImageView getMoreButton() {
            return this.moreButton;
        }
        
        public final TextView getTitleTextView() {
            return this.titleTextView;
        }
    }
}
