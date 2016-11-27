package br.com.insure.business;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wesley on 26/11/2016.
 */

public class ClienteBD extends SQLiteOpenHelper {

    private static final int BD_VERSAO = 1;
    private static final String BD_NOME = "DB_CLIENTE";
    private static final String BD_TABELA = "CLIENTE";

    private static final String CAMPO_CODIGO = "codigo";
    private static final String CAMPO_NOME = "nome";
    private static final String CAMPO_EMAIL = "email";
    private static final String CAMPO_SENHA = "senha";

    public ClienteBD(Context context){
        super(context, BD_NOME, null, BD_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + BD_TABELA + "(" +
                CAMPO_CODIGO + " INTEGER PRIMARY KEY," +
                CAMPO_NOME + " TEXT," +
                CAMPO_EMAIL + " TEXT," +
                CAMPO_SENHA + " TEXT)";

        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BD_TABELA);
        onCreate(db);
    }

    public boolean salvar(Cliente cliente, int operacao){
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            if(existe(cliente)){
                return false;
            }

            ContentValues values = new ContentValues();
            values.put(CAMPO_NOME, cliente.getNome());
            values.put(CAMPO_EMAIL, cliente.getEmail());
            values.put(CAMPO_SENHA, cliente.getSenha());

            if(operacao == 1){
                db.update(BD_TABELA, values, CAMPO_CODIGO + " = ?", new String[]{String.valueOf(cliente.getCodigo())});
            } else{
                db.insert(BD_TABELA, null, values);
            }

            db.close();

            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean acessar(Cliente cliente){
        try {
            String sql = "SELECT * FROM " + BD_TABELA +
                         " WHERE EMAIL = '" + cliente.getEmail() + "'";

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(sql, null);

            Cliente objCliente = null;

            if (cursor.moveToFirst()) {
                do {
                    objCliente = new Cliente();
                    objCliente.setCodigo(Integer.parseInt(cursor.getString(0)));
                    objCliente.setNome(cursor.getString(1));
                    objCliente.setEmail(cursor.getString(2));
                    objCliente.setSenha(cursor.getString(3));
                } while (cursor.moveToNext());
                cursor.close();
                db.close();
            }

            return objCliente != null;
        } catch (Exception e){
            return false;
        }
    }

    public boolean existe(Cliente cliente){
        try {
            String sql = "SELECT * FROM " + BD_TABELA +
                         " WHERE EMAIL = '" + cliente.getEmail() + "'";

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(sql, null);

            if (cursor.moveToFirst()) {
                cursor.close();
                db.close();
                return true;
            }

            return false;
        } catch (Exception e){
            return false;
        }
    }
}
