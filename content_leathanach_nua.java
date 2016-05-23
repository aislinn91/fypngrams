<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    app:layout_behavior="@string/appbar_scrolling_view_behavior"
    tools:context="com.example.aislinnmorrhouse.predictiteacs.leathanachNua"
    tools:showIn="@layout/activity_leathanach_nua">

    <EditText
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/editText1"
        android:inputType="textMultiLine"
        android:isScrollContainer="true"
        android:layout_alignParentRight="true"
        android:layout_alignParentEnd="true"
        android:layout_alignParentTop="true"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true"
        android:text="@string/chuir_an_gaeilge_isteach_sa_mbosca" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="taispéan"
        android:id="@+id/button2"
        android:layout_below="@+id/editText1"
        android:layout_alignEnd="@+id/editText1" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text=""
        android:id="@+id/textView1"
        android:layout_alignBottom="@+id/button2"
        android:layout_alignParentStart="true" />

    <ImageButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/araisbutton"
        android:src="@drawable/back"
        android:layout_alignParentBottom="true"
        android:layout_marginBottom="89dp" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="sonraí"
        android:id="@+id/databtn"
        android:layout_alignTop="@+id/button2"
        android:layout_toStartOf="@+id/button2" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/textView2"
        android:layout_alignEnd="@+id/araisbutton"
        android:layout_below="@+id/textView1" />

</RelativeLayout>
