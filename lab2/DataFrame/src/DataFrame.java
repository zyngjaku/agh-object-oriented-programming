import java.util.ArrayList;

public class DataFrame {

    String _names[];
    String _types[];

    ArrayList<Column> cols = new ArrayList<Column>();
    int number_of_cols;
    int number_of_rows;

    DataFrame(String names[], String types[]) {
        _names = names;
        _types = types;

        number_of_cols = names.length;
        number_of_rows = 0;

        for (int i = 0; i < number_of_cols; i++) {
            cols.add(new Column(names[i], types[i]));
        }
    }

    DataFrame(Column columns []){
        number_of_cols = columns.length;
        number_of_rows = columns[0].column_size;

        String tmp_names[] = new String[number_of_cols];
        String tmp_types[] = new String[number_of_cols];

        int i=0;

        for (Column col : columns) {
            if(col.column_size!= number_of_rows){
                System.out.println("columns are not equal");
            }
            cols.add(col);
            tmp_names[i]= col.column_name;
            tmp_types[i]= col.column_type;


        }

        _names = tmp_names;
        _types = tmp_types;
    }

    Column get(String col_name) {
        for (Column col : cols) {
            if (col_name.equals(col.column_name)) {
                return col;

            }
        }

        return new Column();
    }


    boolean addRow(Object objects []){
        if (objects.length != number_of_rows){
            return false;
        }

        for (Column col : cols) {
            for (Object obj : objects) {

                col.add_element(obj);
            }
        }

        number_of_rows++;

        return true;
    }

    int size(){
        return number_of_rows;
    }

}

