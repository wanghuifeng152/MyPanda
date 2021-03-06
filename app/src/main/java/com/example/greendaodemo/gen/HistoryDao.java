package com.example.greendaodemo.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.greendao.History;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "HISTORY".
*/
public class HistoryDao extends AbstractDao<History, Long> {

    public static final String TABLENAME = "HISTORY";

    /**
     * Properties of entity History.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Image = new Property(1, String.class, "image", false, "image");
        public final static Property Titlr = new Property(2, String.class, "titlr", false, "title");
        public final static Property Sum = new Property(3, String.class, "sum", false, "sum");
        public final static Property Stims = new Property(4, String.class, "stims", false, "stims");
    }


    public HistoryDao(DaoConfig config) {
        super(config);
    }
    
    public HistoryDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"HISTORY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"image\" TEXT," + // 1: image
                "\"title\" TEXT," + // 2: titlr
                "\"sum\" TEXT," + // 3: sum
                "\"stims\" TEXT);"); // 4: stims
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"HISTORY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, History entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String image = entity.getImage();
        if (image != null) {
            stmt.bindString(2, image);
        }
 
        String titlr = entity.getTitlr();
        if (titlr != null) {
            stmt.bindString(3, titlr);
        }
 
        String sum = entity.getSum();
        if (sum != null) {
            stmt.bindString(4, sum);
        }
 
        String stims = entity.getStims();
        if (stims != null) {
            stmt.bindString(5, stims);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, History entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String image = entity.getImage();
        if (image != null) {
            stmt.bindString(2, image);
        }
 
        String titlr = entity.getTitlr();
        if (titlr != null) {
            stmt.bindString(3, titlr);
        }
 
        String sum = entity.getSum();
        if (sum != null) {
            stmt.bindString(4, sum);
        }
 
        String stims = entity.getStims();
        if (stims != null) {
            stmt.bindString(5, stims);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public History readEntity(Cursor cursor, int offset) {
        History entity = new History( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // image
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // titlr
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // sum
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // stims
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, History entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setImage(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTitlr(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSum(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setStims(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(History entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(History entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(History entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
