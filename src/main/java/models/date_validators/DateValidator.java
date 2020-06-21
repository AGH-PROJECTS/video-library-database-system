package models.date_validators;


import javafx.scene.control.TextField;

public class DateValidator <T>{
    public boolean validate(T item){
        if(!item.equals(null)&&!item.equals("")) return true;
        else return false;
    }
    public boolean validateString(String item){
        if(!item.equals(null)&&!item.equals("")) return true;
        else return false;
    }

    public void clearUserFields(TextField item1, TextField item2, TextField item3, TextField item4, TextField item5, TextField item6){
        item1.setText("");
        item2.setText("");
        item3.setText("");
        item4.setText("");
        item5.setText("");
        item6.setText("");
    }
    public void clearFilmFields(TextField item1, TextField item2, TextField item3, TextField item4, TextField item5,TextField item6,TextField item7){
        item1.setText("");
        item2.setText("");
        item3.setText("");
        item4.setText("");
        item5.setText("");
        item6.setText("");
        item7.setText("");
    }
    public void clearOrderFields(TextField item1, TextField item2, TextField item3, TextField item4, TextField item5,TextField item6,TextField item7){
        item1.setText("");
        item2.setText("");
        item3.setText("");
        item4.setText("");
        item5.setText("");
        item6.setText("");
        item7.setText("");
    }
}
