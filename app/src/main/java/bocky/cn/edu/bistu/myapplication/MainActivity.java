package bocky.cn.edu.bistu.myapplication;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.math.BigDecimal;

/**
*
*@author Bocky
* created at 2018/3/22 17:02
*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    double num1 = 0, num2 = 0;//接收运算前后的值
    BigDecimal b1 , b2 ;
    double Result = 0;//运算结果
    double bottom = 0;
    int flag = 0;//判断操作数
    int i=1;
    boolean ispoint = false;      //判断"."是否存在.
    boolean isClickequal = false;//判断用户是否按了"="

    /*数字按钮*/
    private Button button00;
    Button button01;
    Button button02;
    Button button03;
    Button button04;
    Button button05;
    Button button06;
    Button button07;
    Button button08;
    Button button09;
    /*运算符号*/
    Button add;
    Button sub;
    Button mult;
    Button division;
    Button equal;
    Button point;
    /*操作符*/
    Button delete;
    Button back;
    Button percent;
    Button sqrt;

    EditText edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button00 = (Button) findViewById(R.id.button00);
        button01 = (Button) findViewById(R.id.button01);
        button02 = (Button) findViewById(R.id.button02);
        button03 = (Button) findViewById(R.id.button03);
        button04 = (Button) findViewById(R.id.button04);
        button05 = (Button) findViewById(R.id.button05);
        button06 = (Button) findViewById(R.id.button06);
        button07 = (Button) findViewById(R.id.button07);
        button08 = (Button) findViewById(R.id.button08);
        button09 = (Button) findViewById(R.id.button09);

        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mult = (Button) findViewById(R.id.mult);
        division = (Button) findViewById(R.id.division);
        equal = (Button) findViewById(R.id.equal);
        point = (Button) findViewById(R.id.point);

        delete = (Button) findViewById(R.id.delete);
        back = (Button) findViewById(R.id.back);
        percent = (Button) findViewById(R.id.percent);
        sqrt = (Button) findViewById(R.id.sqrt);

        edit_text = (EditText) findViewById(R.id.edit_text);

        //设置以上按钮的点击事件
        button00.setOnClickListener(this);
        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
        button03.setOnClickListener(this);
        button04.setOnClickListener(this);
        button05.setOnClickListener(this);
        button06.setOnClickListener(this);
        button07.setOnClickListener(this);
        button08.setOnClickListener(this);
        button09.setOnClickListener(this);

        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mult.setOnClickListener(this);
        division.setOnClickListener(this);
        equal.setOnClickListener(this);
        point.setOnClickListener(this);

        delete.setOnClickListener(this);
        back.setOnClickListener(this);
        percent.setOnClickListener(this);
        sqrt.setOnClickListener(this);
    }


    /*传递数字*/
    public void num(String number) {

        //判断是否有重复"0"的情况
        if(i>=2){               //运算出结果后直接点数字。进行delete操作。
            edit_text.setText("");
            num1=num2=0;
            ispoint = false;
            isClickequal = false;
            i=1;
        }
        String str1 = edit_text.getText().toString();
        if (str1.equals("0") && !number.equals(".")) {
            edit_text.setText("");
        }/*检测小数点*/
        if (number.equals(".")) {//点击了"."按钮
            if (ispoint) {
               Toast.makeText(MainActivity.this,"请勿重复输入小数点",Toast.LENGTH_SHORT).show();
                return;
            }
            ispoint = true;
            if (str1.equals("")) {//文本框为空时点击"."
                edit_text.setText("0.");
            } else {
                edit_text.append(".");
            }

            return;
        }
        edit_text.append(number);
    }
    /*运算符传递*/
    public void operator(int op){
        String str2 = edit_text.getText().toString();
        Equal(isClickequal);
        if(str2.equals("")){//文本框为空时点击运算符
            Toast.makeText(MainActivity.this,"请输入数字",Toast.LENGTH_SHORT).show();
            return;
        }
        num1 = Double.valueOf(str2);//强制类型转换，避免java中精度损失的问题 eg： 0.3-0.1=0.199999999
        b1 = new BigDecimal(Double.toString(num1));
        edit_text.setText("");      //文本框置空，防止干扰第二个数的读取
        flag = op;                  //传递flag量
        ispoint = false;
        isClickequal = false;
    }

    /*结果为整数时进行去精度*/
    public double Doubletoint(double result) {
        int n = 0;
        n = (int) result;
        if (result == n) {                      /*值相等时意味着传递整数，返回int值*/
            edit_text.setText(String.valueOf(n));
            return n;
        } else {                                /*值不等时意味着传递小数，返回double值，并且将ispoint信号量置为true*/
            edit_text.setText(String.valueOf(result));
            ispoint = true;
            return result;
        }
    }

    /*等号判定*/
    public void Equal(boolean eq) {
        if (eq) {
            edit_text.setText(null);
            eq = false;
        }
    }

    @Override
    public void onClick(View v) {                        //针对按钮点击事件的监听
        String str = edit_text.getText().toString();    //获取EditText中的字符串
        switch (v.getId()) {
            case R.id.button00:
                Equal(isClickequal);
                num("0");
                break;

            case R.id.button01:
                Equal(isClickequal);
                num("1");
                break;

            case R.id.button02:
                Equal(isClickequal);
                num("2");
                break;

            case R.id.button03:
                Equal(isClickequal);
                num("3");
                break;

            case R.id.button04:
                Equal(isClickequal);
                num("4");
                break;

            case R.id.button05:
                Equal(isClickequal);
                num("5");
                break;

            case R.id.button06:
                Equal(isClickequal);
                num("6");
                break;

            case R.id.button07:
                Equal(isClickequal);
                num("7");
                break;

            case R.id.button08:
                Equal(isClickequal);
                num("8");
                break;

            case R.id.button09:
                Equal(isClickequal);
                num("9");
                break;


            case R.id.point:
                Equal(isClickequal);
                num(".");
                break;

            case R.id.add:
                Equal(isClickequal);
                operator(1);
                break;

            case R.id.sub:
                Equal(isClickequal);
                operator(2);
                break;

            case R.id.mult:
                Equal(isClickequal);
                operator(3);
                break;

            case R.id.division:
                Equal(isClickequal);
                operator(4);
                break;

            case R.id.percent:
                Equal(isClickequal);
                if(str.equals("")){//文本框为空时点击运算符
                    Toast.makeText(MainActivity.this,"请输入数字",Toast.LENGTH_SHORT).show();
                    return;
                }
                num1 = Double.valueOf(str);
                num1 = 0 - num1;
                Doubletoint(num1);
                str = String.valueOf(num1);
                ispoint = false;
                isClickequal = false;
                break;

            case R.id.sqrt:
                Equal(isClickequal);
                if(str.equals("")){//文本框为空时点击运算符
                    Toast.makeText(MainActivity.this,"请输入数字",Toast.LENGTH_SHORT).show();
                    return;
                }
                num1 = Double.valueOf(str);
                if(num1<0){
                    Toast.makeText(MainActivity.this,"请输入一个正数",Toast.LENGTH_SHORT).show();
                    return;

                }
                num1 = Math.sqrt(num1);
                Doubletoint(num1);
                str = String.valueOf(num1);
              //  i++;
                ispoint = false;
                isClickequal = false;
                break;

            case R.id.delete:
                Equal(isClickequal);
                edit_text.setText("");
                num1 = 0;
                num2 = 0;
                ispoint = false;
                isClickequal = false;
                i=1;
                break;

            case R.id.back:
                Equal(isClickequal);
                try {
                    edit_text.setText(str.substring(0, str.length() - 1));
                } catch (Exception e) {
                    edit_text.setText("");
                }
                isClickequal = false;
                break;

            case R.id.equal:
                getResult();
                break;
            default:
                break;

        }
    }

    private void getResult() {
        String str1 = edit_text.getText().toString();
        if (str1.equals("")) {
            edit_text.setText("");
        } else {
            num2 = Double.valueOf(str1);
             b2 = new BigDecimal(Double.toString(num2));
            if(i>=2){                               //解决等号连乘问题。
                num1=num2;
                b1 = new BigDecimal(Double.toString(num1));
                num2=bottom;
                b2 = new BigDecimal(Double.toString(num2));
            }
            switch (flag) {
                case 0:
                    Result = num2;
                    break;
                case 1:
                    Result = b1.add(b2).doubleValue();
                    break;
                case 2:
                    Result = b1.subtract(b2).doubleValue();
                    break;
                case 3:
                    Result = b1.multiply(b2).doubleValue();
                    break;
                case 4:
                    Result = num1 / num2;
                    break;
                default:
                    Result = 0;
                    break;
            }

            Doubletoint(Result);
            if(i==1){
                bottom = num2;
            }

            i++;
            isClickequal = false;
        }
    }
}













