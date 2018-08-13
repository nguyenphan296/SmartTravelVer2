package com.example.nguyenanhphan.smarttravelver2.Common;

import android.view.View;

public interface ItemClickListener<T> {
    void onClickItem(int position, T item);
    void onLongClickItem(int position, T item);
}
