package app.andre.appminhaideiadb.datamodel;

public class ClienteDataModel {

    public static final String TABLE = "cliente";
    public static final String ID = "id";
    public static final String NAME = "nome";
    public static final String EMAIL = "email";

    public static String queryCreateTable = "";

    public static String createTable() {

        queryCreateTable += "CREATE TABLE " + TABLE + " (";
        queryCreateTable += ID + " integer primary key autoincrement, ";
        queryCreateTable += NAME + " text, ";
        queryCreateTable += EMAIL + " text)";

        return queryCreateTable;
    }
}
