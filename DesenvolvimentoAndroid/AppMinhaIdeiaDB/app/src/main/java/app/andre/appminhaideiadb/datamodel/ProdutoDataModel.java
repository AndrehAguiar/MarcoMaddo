package app.andre.appminhaideiadb.datamodel;

public class ProdutoDataModel {

    public static final String TABLE = "produto";
    public static final String ID = "id";
    public static final String NAME = "nome";
    public static final String FORNECEDOR = "fornecedor";

    public static String queryCreateTable = "";

    public static String createTable() {

        queryCreateTable += "CREATE TABLE " + TABLE + " (";
        queryCreateTable += ID + " integer primary key autoincrement, ";
        queryCreateTable += NAME + " text, ";
        queryCreateTable += FORNECEDOR + " text)";

        return queryCreateTable;
    }
}
