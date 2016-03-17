package com.hathy.listsandcards;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class MyRecyclerViewTouchListener implements RecyclerView.OnItemTouchListener{
    private GestureDetector gestureDetector ;
    private RecyclerViewActivity.MyClickListener myClickListener ;

    public MyRecyclerViewTouchListener(Context context, final RecyclerView recyclerView,
                                   final RecyclerViewActivity.MyClickListener myClickListener){
        this.myClickListener = myClickListener ;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true ;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View childView = recyclerView.findChildViewUnder(e.getX(), e.getY()) ;
                if(childView != null && myClickListener != null){
                    myClickListener.onLongClick(childView, recyclerView.getChildPosition(childView));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View childview = rv.findChildViewUnder(e.getX(), e.getY()) ;
        if (childview != null && myClickListener != null && gestureDetector.onTouchEvent(e)) {
            myClickListener.onClick(childview, rv.getChildPosition(childview));

        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
