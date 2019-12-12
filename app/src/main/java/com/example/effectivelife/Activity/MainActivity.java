package com.example.effectivelife.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.DatePickerDialog;
import android.widget.DatePicker;

import java.util.Calendar;


import com.example.effectivelife.R;

public class MainActivity extends Activity implements
        View.OnClickListener {
private EditText editText;
    EditText name_of_goods;
    EditText best_before_of_goods;
    EditText amount_of_goods;
    Button btnDatePicker;
    EditText txtDate;
    EditText testText;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnDatePicker = (Button) findViewById(R.id.btn_date);
        txtDate = (EditText) findViewById(R.id.best_before_of_goods);
        btnDatePicker.setOnClickListener(this);
editText = (EditText) findViewById(R.id.best_before_of_goods);
testText = (EditText) findViewById(R.id.amount_of_goods);




    }


    @Override
    public void onClick (View v) {

            if (v == btnDatePicker) {

                // Создаём текущую дату
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
  // Проверяем поля, если дата дня и месяца меньше 10, то добавляется 0 перед днём/месяцем)
if ( dayOfMonth <9 & monthOfYear <9)
    txtDate.setText("0" + (dayOfMonth) + "-" + "0" + (monthOfYear + 1) + "-" + year);
else if (dayOfMonth < 9 )
    txtDate.setText("0" + dayOfMonth + "-" +(monthOfYear + 1) + "-" + year);
else if (monthOfYear < 9)
    txtDate.setText((dayOfMonth) + "-" + "0" + (monthOfYear + 1) + "-" + year);
        else                         txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }

    }

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final EditText name_of_goods = (EditText) findViewById(R.id.name_of_goods); //присваиваем переменную полю ввода "Наименование товара"
        final EditText best_before_of_goods = (EditText) findViewById(R.id.best_before_of_goods); //присваивает переменную полю ввода "Срок годности"
        final EditText amount_of_goods = (EditText) findViewById(R.id.amount_of_goods); //присваивает переменную полю ввода "Количество"
        final Button add_button = (Button) findViewById(R.id.add_button); //присваивает переменную кнопке "Добавить"
        ListView items = (ListView) findViewById(R.id.items);
        final ArrayList<String> items_list = new ArrayList<>(); //пустой массив для хранения данных
        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items_list);
       // ListView.setAdapter(adapter);


//    Убрал из кода, так как приложение с этой строкой не запускается.    items.setAdapter(goodsAdapter);

        //Присваивает переменную адаптору, который будет собирать данные
        // наименования товара, кол-ва и срока годности, для дальнейшей обработки
      /*  add_button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goodsAdapter.add(new Product(name_of_goods.getText().toString(), Integer.valueOf(best_before_of_goods.getText().toString()), Integer.valueOf(amount_of_goods.getText().toString())));
            }
            }));

}
*/


 /*   public void OnClick (View view){
        switch (view.getId()){
            case R.id.items_list:
                Intent intent = new Intent(this, ItemsTableActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

*/

   /*     private class ItemsAdapter extends ArrayAdapter<Product> {
            public ItemsAdapter() {
                super(MainActivity.this, R.layout.list_view);
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                final View view = getLayoutInflater().inflate(R.layout.list_view, null);
                final Product product = getItem(position);
                ((TextView) view.findViewById(R.id.name_of_goods)).setText(product.name);
                ((TextView) view.findViewById(R.id.amount_of_goods)).setText(String.valueOf(product.amount));
                ((TextView) view.findViewById(R.id.best_before_of_goods)).setText(String.valueOf(product.date));
                return view;
                }
                }
*/

      //  }


    public void btn_today_items(View view) {
        Intent intent = new Intent(MainActivity.this, ItemsTableActivity.class);
        startActivity(intent);
    }


    public void btn_calendar_view(View view) {
        Intent intent = new Intent(MainActivity.this, CaldroidSampleActivity.class);
        startActivity(intent);
    }
}
