# UI-Test

# 安卓UI实验<br>
<br>
<br>

## 主页面

 该部分主要是用来在对四个页面进行跳转访问

 1. 主要代码：
 ```
   //ConsoleActivity.java
   
        Button sample=findViewById(R.id.button_sample);
        Button dialog=findViewById(R.id.button_dialog);
        Button menu=findViewById(R.id.button_menu);
        Button action=findViewById(R.id.button_actionmode);

        sample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ConsoleActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ConsoleActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ConsoleActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });

        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ConsoleActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
 ```
2. 截图：

![在这里插入图片描述](https://img-blog.csdnimg.cn/2019032422582242.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FpbmdmZW5nbG9zZXI=,size_16,color_FFFFFF,t_70)

## SampleAdapter 实现列表
1. 主要代码：
```
    final String[] animals={
            "Lion",
            "Tiger",
            "Monkey",
            "Dog",
            "Cat",
            "Elephant"
    };

    final int[] picId={
            R.drawable.lion,
            R.drawable.tiger,
            R.drawable.monkey,
            R.drawable.dog,
            R.drawable.cat,
            R.drawable.elephant
    };
    //sampleAdapter实例，也可用自己定义一个AnimalAdapter实现，效果相同
    private List<Map<String,Object>> lists=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<animals.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("name",animals[i]);
            map.put("image",picId[i]);
            lists.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                MainActivity.this,
                lists,
                R.layout.simplelayout,
                new String[] {"name","image"},
                new int[]{R.id.animal_text,R.id.animal_image}
                );
        final ListView listView = (ListView) findViewById(R.id.listview);
        if(listView!=null)
            listView.setAdapter(adapter);
        else
            Toast.makeText(this,
                    "空的listview",
                    Toast.LENGTH_SHORT).show();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        view.setSelected(true);
                        Toast.makeText(MainActivity.this,
                                animals[position],
                                Toast.LENGTH_SHORT
                        ).show();
            }
        });
    }
```

布局文件就两个，一个是listView，表示页面布局。
另一个就是listView每一行的布局方式，如下：

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <TextView
            android:id="@+id/animal_text"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="3"
            android:text="@string/animal_Lion"
            android:layout_gravity="center"
            android:textSize="25sp" />

        <ImageView
            android:id="@+id/animal_image"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:adjustViewBounds="true"
            android:layout_weight="1" />
    </LinearLayout>
    <View
        android:layout_width="match_parent"
        android:layout_height="1dp"
        android:background="@android:color/black"
        />
</LinearLayout>
```
其中ImageView中“ android:adjustViewBounds="true" ”这一句的作用是自动调解图片的边界

2. 截图

![在这里插入图片描述](https://img-blog.csdnimg.cn/2019032423053042.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FpbmdmZW5nbG9zZXI=,size_16,color_FFFFFF,t_70)

## 创建自定义布局的Dialog
1. 主要代码：
```
        Button assure=(Button) findViewById(R.id.assure);
        assure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(DialogActivity.this);
                dialog.setView(R.layout.logonlayout);
                dialog.setCancelable(false);
                dialog.setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });
```

布局文件方面就一个button，点一下就弹出Dialog.

然后Dialog的布局如下：

```

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/linearLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_gravity="center">

    <TextView
        android:id="@+id/textView"
        android:layout_width="409dp"
        android:layout_height="72dp"
        android:layout_marginStart="32dp"
        android:layout_marginEnd="32dp"
        android:background="#ff0"
        android:gravity="center"
        android:text="@string/login"
        android:textSize="20dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/editText"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="@string/username"
        android:textSize="20dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView" />

    <EditText
        android:id="@+id/editText2"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="@string/password"
        android:textSize="20dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText" />
</android.support.constraint.ConstraintLayout>

```

2. 截图

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190324231013143.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FpbmdmZW5nbG9zZXI=,size_16,color_FFFFFF,t_70)

## 使用xml定义菜单

1.  主要代码：

```
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final EditText editText=(EditText) findViewById(R.id.editText3);
        switch(item.getItemId()){
            case R.id.big:
                editText.setTextSize(20);
                break;
            case R.id.middle:
                editText.setTextSize(16);
                break;
            case R.id.small:
                editText.setTextSize(10);
                break;
            case R.id.normal:
                Toast.makeText(this,"You clicked normal menu item!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.red:
                editText.setTextColor(Color.RED);
                break;
            case R.id.black:
                editText.setTextColor(Color.BLACK);
                break;
            default:
        }
        return true;
    }
```
2. menu文件：
```

<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
  <item android:id="@+id/fontsize"
        android:title="@string/font_size">
    <menu>
      <item android:id="@+id/big"
          android:title="大" />
      <item android:id="@+id/middle"
          android:title="中"/>
      <item android:id="@+id/small"
          android:title="小"/>
    </menu>
  </item>
  <item android:id="@+id/normal"
      android:title="@string/normal">
  </item>
  <item android:id="@+id/fontcolor"
      android:title="@string/font_color">
    <menu>
      <item android:id="@+id/red"
          android:title="红色"/>
      <item android:id="@+id/black"
          android:title="黑色"/>
    </menu>
  </item>
</menu>

```

主界面就一个EditView来输入文字进行测试

3. 截图：

字体：小字体

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190324231855163.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FpbmdmZW5nbG9zZXI=,size_16,color_FFFFFF,t_70)

颜色：红色

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190324231947551.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FpbmdmZW5nbG9zZXI=,size_16,color_FFFFFF,t_70)

普通菜单项：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190324232019799.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FpbmdmZW5nbG9zZXI=,size_16,color_FFFFFF,t_70)

## ActionMode创建上下文菜单

1. 主要代码：

```

public class ListActivity extends AppCompatActivity {

    String []name=new String[]{
            "One",
            "Two",
            "Three",
            "Four",
            "Five"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        final List<Map<String,Object>> list=new ArrayList<>();
        for(int i=0;i<5;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("pic",R.drawable.ic_launcher);
            map.put("name",name[i]);
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                list,
                R.layout.layout_list_menu,
                new String[] {"pic","name"},
                new int[]{R.id.image_list,R.id.text_list}
        );
        final ListView listView = (ListView) findViewById(R.id.view_list);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);//选项可以多选
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                listView.setSelection(position);
                mode.setTitle(listView.getCheckedItemCount()+" selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater=mode.getMenuInflater();
                inflater.inflate(R.menu.actionmode,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.delete:
                        Toast.makeText(ListActivity.this,"you want delete your selected!", Toast.LENGTH_SHORT).show();
                        mode.finish();
                        return true;
                    case R.id.select:
                        Toast.makeText(ListActivity.this,"you want cancel your selected!", Toast.LENGTH_SHORT).show();
                        mode.finish();
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }
}
```
<br>主要是通过实现AbsListView.MultiChoiceModeListener接口。 

在onItemCheckedStateChanged函数中设置选中item时Actionbar显示的信息。

然后关键是onCreateActionMode加载menu布局文件

onActionItemClicked函数里面设置点击两个菜单的反应。


menu文件：

    <item android:id="@+id/select"
        android:icon="@drawable/select"
        android:title="选择"
        app:showAsAction="ifRoom"/>
    <item android:id="@+id/delete"
        android:icon="@drawable/delete"
        android:title="删除"
        app:showAsAction="ifRoom"/>
    
</menu>
	主页面就一个ListView,每行的布局跟题目一差不多，同样是使用SampleAdapter来设置每行的数据。

2. 截图：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190324233417181.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FpbmdmZW5nbG9zZXI=,size_16,color_FFFFFF,t_70)

## 实验总结
本次实验收获还是蛮大的，最后一道题在没看到文档时困扰了好久，最后也就做出这个效果了，尽力了哈哈哈哈。
