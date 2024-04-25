package com.maratodev.notesapp;

import kotlin.jvm.internal.Intrinsics;
import kotlin.Metadata;

@Metadata(d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016" }, d2 = { "Lcom/maratodev/notesapp/Note;", "", "id", "", "title", "", "content", "(ILjava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getId", "()I", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_debug" }, k = 1, mv = { 1, 8, 0 }, xi = 48)
public final class Note
{
    private final String content;
    private final int id;
    private final String title;
    
    public Note(final int id, final String title, final String content) {
        Intrinsics.checkNotNullParameter((Object)title, "title");
        Intrinsics.checkNotNullParameter((Object)content, "content");
        this.id = id;
        this.title = title;
        this.content = content;
    }
    
    public final int component1() {
        return this.id;
    }
    
    public final String component2() {
        return this.title;
    }
    
    public final String component3() {
        return this.content;
    }
    
    public final Note copy(final int n, final String s, final String s2) {
        Intrinsics.checkNotNullParameter((Object)s, "title");
        Intrinsics.checkNotNullParameter((Object)s2, "content");
        return new Note(n, s, s2);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Note)) {
            return false;
        }
        final Note note = (Note)o;
        return this.id == note.id && Intrinsics.areEqual((Object)this.title, (Object)note.title) && Intrinsics.areEqual((Object)this.content, (Object)note.content);
    }
    
    public final String getContent() {
        return this.content;
    }
    
    public final int getId() {
        return this.id;
    }
    
    public final String getTitle() {
        return this.title;
    }
    
    @Override
    public int hashCode() {
        return (Integer.hashCode(this.id) * 31 + this.title.hashCode()) * 31 + this.content.hashCode();
    }
    
    @Override
    public String toString() {
        return "Note(id=" + this.id + ", title=" + this.title + ", content=" + this.content + ')';
    }
}
