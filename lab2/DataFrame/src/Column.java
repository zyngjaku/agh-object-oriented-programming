import java.util.ArrayList;

public class Column {
    String column_name;
    String column_type;
    int column_size;

    ArrayList<Object> column_elements = new ArrayList<Object>();

    Column(){
        System.out.println("err");
    }

    Column(String name, String type){
        column_name = name;
        column_type = type;
        column_size = 0;
    }

    void add_element(Object object){
        column_elements.add(object);

        column_size++;
    }

    Object get_element(int index){
        return column_elements.get(index-1);
    }
}
