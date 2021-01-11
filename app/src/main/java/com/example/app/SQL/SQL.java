package com.example.app.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.app.Object.account;
import com.example.app.Object.cart;
import com.example.app.model.Popular;
import com.example.app.model.Recommended;

import java.util.ArrayList;
import java.util.List;

public class SQL extends SQLiteOpenHelper {

    public SQL(@Nullable Context context) {
        super(context, "sinhvien.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //tao bang account
        String create_Account="create table account(id integer primary key autoincrement, username nvarchar(50), password nvarchar(50))";
        db.execSQL(create_Account);
        //tao bang new product
        String newproduct="create table newproduct(id integer primary key autoincrement,name text(10), imageUrl text(100), rating text(10),deliveryTime text(20), deliveryCharges text(20),price text(20), note text(20))";
        db.execSQL(newproduct);
        //tao bang popular
        String popular="create table popular(id integer primary key autoincrement,name text(10), imageUrl text(100), rating text(10),deliveryTime text(20), deliveryCharges text(20),price text(20), note text(20))";
        db.execSQL(popular);
        //tao bang cart
        String cart="create table cart(id integer primary key autoincrement,idPro int(10),quanlity int(10))";
        db.execSQL(cart);

        // insert du lieu vao bang popular
        String ROW1 = "INSERT INTO popular" + " Values (1,'Chó bông','dog1','5.0','4.5 minis', 'Miễn phí vận chuyển','150','Extra special');";
        db.execSQL(ROW1);

        String ROW2 = "INSERT INTO popular"  + " Values (2,'Chó xù','dog2','5.0','4.5 minis', 'Miễn phí vận chuyển','150','Extra special');";
        db.execSQL(ROW2);

        String ROW3 = "INSERT INTO popular"   + " Values (3,'Chó xù 1','dog3','5.0','4.5 minis', 'Miễn phí vận chuyển','150','Extra special');";
        db.execSQL(ROW3);
        String ROW4 = "INSERT INTO popular"   + " Values (4,'Chó xù 2','dog4','5.0','4.5 minis', 'Miễn phí vận chuyển','150','Extra special');";
        db.execSQL(ROW4);
        String ROW5 = "INSERT INTO popular"   + " Values (5,'Chó xù 3','dog5','5.0','4.5 minis', 'Miễn phí vận chuyển','150','Extra special');";
        db.execSQL(ROW5);
        String ROW6 = "INSERT INTO popular"   + " Values (6,'Chó xù 4','dog6','5.0','4.5 minis', 'Miễn phí vận chuyển','150','Extra special');";
        db.execSQL(ROW6);
        String ROW7 = "INSERT INTO popular"   + " Values (7,'Chó xù 5','dog1','5.0','4.5 minis', 'Miễn phí vận chuyển','150','Extra special');";
        db.execSQL(ROW7);
        // insert du lieu vao bang new product
        String R1 = "INSERT INTO newproduct" + " Values (1,'Chó xù 6','dog2','5.0','4.5 minis', 'Miễn phí vận chuyển','150000','Extra special');";
        db.execSQL(R1);

        String R2 = "INSERT INTO newproduct"  + " Values (2,'Chó xù 7','dog3','5.0','4.5 minis', 'Miễn phí vận chuyển','230000','Extra special');";
        db.execSQL(R2);

        String R3 = "INSERT INTO newproduct"   + " Values (3,'Chó xù 8','dog5','5.0','4.5 minis', 'Miễn phí vận chuyển','1700000','Extra special');";
        db.execSQL(R3);

        String R4 = "INSERT INTO newproduct"   + " Values (4,'Chó xù 9','dog6','5.0','4.5 minis', '15k nội thành','7600000','Extra special');";
        db.execSQL(R4);

        String R5 = "INSERT INTO newproduct"   + " Values (5,'Chó xù 10','dog4','5.0','4.5 minis', '15k nội thành','4560000','Extra special');";
        db.execSQL(R5);
//
    }
    public void addCart(cart cart){
        SQLiteDatabase database= getWritableDatabase();
        boolean check=false;
        for (int i=0;i<getCart().size();i++){
            if(cart.getIdPro()==getCart().get(i).getIdPro()){
                database.execSQL("UPDATE cart SET quanlity = "+"'"+(Integer.valueOf(getCart().get(i).getQuanlity())+1)+"' "+ "WHERE idPro = "+"'"+cart.getIdPro()+"'");
                check=true;
                Log.d("quanlity",String.valueOf(Integer.valueOf(getCart().get(i).getQuanlity())+1));
                break;
            }
        }
        if(check==true){
            this.getCart();
            Log.d("du lieu","quanlity +1");
        }else{
            ContentValues contentValues= new ContentValues();
            contentValues.put("idPro",cart.getIdPro());
            contentValues.put("quanlity",1);
            database.insert("cart",null,contentValues);
            Log.d("du lieu","thanh cong");
        }


    }

    public  void delete(int id){
        SQLiteDatabase database= getWritableDatabase();
        database.execSQL("DELETE FROM cart Where idPro ="+"'"+id+"'");
        Log.d("thực hiện","xoa dữ liệu");
        this.getCart();
    }

    public void addAccount(account account){
        SQLiteDatabase database= getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username",account.getUserName());
        contentValues.put("password",account.getPassWord());
        database.insert("account",null,contentValues);
    }

    public List<cart> getCart(){
        List<cart> cartList=new ArrayList<>();
        String getUser="select * from cart";
        SQLiteDatabase db=getReadableDatabase();

        Cursor cursor=db.rawQuery(getUser,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id, idPro, quanlity;
            id=cursor.getInt(0);
            idPro=cursor.getInt(1);
            quanlity=cursor.getInt(2);
            cart ac=new cart(id, idPro,quanlity );
            cartList.add(ac);
            cursor.moveToNext();

        }
        Log.d("them sp","hien thi ra man hinh");
        cursor.close();
        return cartList;
    }

    public List<Recommended> getRecoment(){
        List<Recommended> recommendedList=new ArrayList<>();
        String getUser="select * from newproduct";
        SQLiteDatabase db=getReadableDatabase();

        Cursor cursor=db.rawQuery(getUser,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id;
            String name,  imageUrl,  rating,  deliveryTime,  deliveryCharges,  price,  note;
            id=cursor.getInt(0);
            name=cursor.getString(1);
            imageUrl=cursor.getString(2);
            rating=cursor.getString(3);
            deliveryTime=cursor.getString(4);
            deliveryCharges=cursor.getString(5);
            price=cursor.getString(6);
            note=cursor.getString(7);
            Recommended ac=new Recommended(id ,name,  imageUrl,  rating,  deliveryTime,  deliveryCharges,  price, note);
            recommendedList.add(ac);
            cursor.moveToNext();

        }
        cursor.close();
        return recommendedList;
    }


    public List<Popular> getAllPopular(){
        List<Popular> popularList=new ArrayList<>();
        String getUser="select * from popular";
        SQLiteDatabase db=getReadableDatabase();

        Cursor cursor=db.rawQuery(getUser,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String imageUrl;
            String name, rating,  deliveryTime,  deliveryCharges,  price,  note;
            name=cursor.getString(1);
            imageUrl=cursor.getString(2);
            rating=cursor.getString(3);
            deliveryTime=cursor.getString(4);
            deliveryCharges=cursor.getString(5);
            price=cursor.getString(6);
            note=cursor.getString(7);
            Popular ac=new Popular(name,  imageUrl,  rating,  deliveryTime,  deliveryCharges,  price,  note);
            popularList.add(ac);
            cursor.moveToNext();

        }
        cursor.close();
        return popularList;
    }


    public List<account> getAccount(){
        List<account> accountList=new ArrayList<>();
        String getUser="select * from account";
        SQLiteDatabase db=getReadableDatabase();

        Cursor cursor=db.rawQuery(getUser,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id;
            String userName,passWord;
            id=cursor.getInt(0);
            userName=cursor.getString(1);
            passWord=cursor.getString(2);
            account ac=new account(id,userName, passWord);
            accountList.add(ac);
            cursor.moveToNext();

        }
        cursor.close();
        return accountList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
