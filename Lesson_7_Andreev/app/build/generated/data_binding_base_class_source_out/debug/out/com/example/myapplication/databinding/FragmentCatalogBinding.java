// Generated by view binder compiler. Do not edit!
package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentCatalogBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout catalogErrorScreen;

  @NonNull
  public final ProgressBar catalogProgressBar;

  @NonNull
  public final RecyclerView catalogRecyclerView;

  @NonNull
  public final MaterialToolbar catalogToolbar;

  @NonNull
  public final ViewFlipper catalogViewFlipper;

  @NonNull
  public final MaterialButton refreshButton;

  @NonNull
  public final TextView unexpectedErrorDetailed;

  @NonNull
  public final TextView unexpectedErrorText;

  private FragmentCatalogBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout catalogErrorScreen, @NonNull ProgressBar catalogProgressBar,
      @NonNull RecyclerView catalogRecyclerView, @NonNull MaterialToolbar catalogToolbar,
      @NonNull ViewFlipper catalogViewFlipper, @NonNull MaterialButton refreshButton,
      @NonNull TextView unexpectedErrorDetailed, @NonNull TextView unexpectedErrorText) {
    this.rootView = rootView;
    this.catalogErrorScreen = catalogErrorScreen;
    this.catalogProgressBar = catalogProgressBar;
    this.catalogRecyclerView = catalogRecyclerView;
    this.catalogToolbar = catalogToolbar;
    this.catalogViewFlipper = catalogViewFlipper;
    this.refreshButton = refreshButton;
    this.unexpectedErrorDetailed = unexpectedErrorDetailed;
    this.unexpectedErrorText = unexpectedErrorText;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCatalogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCatalogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_catalog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCatalogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.catalogErrorScreen;
      LinearLayout catalogErrorScreen = ViewBindings.findChildViewById(rootView, id);
      if (catalogErrorScreen == null) {
        break missingId;
      }

      id = R.id.catalogProgressBar;
      ProgressBar catalogProgressBar = ViewBindings.findChildViewById(rootView, id);
      if (catalogProgressBar == null) {
        break missingId;
      }

      id = R.id.catalogRecyclerView;
      RecyclerView catalogRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (catalogRecyclerView == null) {
        break missingId;
      }

      id = R.id.catalogToolbar;
      MaterialToolbar catalogToolbar = ViewBindings.findChildViewById(rootView, id);
      if (catalogToolbar == null) {
        break missingId;
      }

      id = R.id.catalogViewFlipper;
      ViewFlipper catalogViewFlipper = ViewBindings.findChildViewById(rootView, id);
      if (catalogViewFlipper == null) {
        break missingId;
      }

      id = R.id.refreshButton;
      MaterialButton refreshButton = ViewBindings.findChildViewById(rootView, id);
      if (refreshButton == null) {
        break missingId;
      }

      id = R.id.unexpectedErrorDetailed;
      TextView unexpectedErrorDetailed = ViewBindings.findChildViewById(rootView, id);
      if (unexpectedErrorDetailed == null) {
        break missingId;
      }

      id = R.id.unexpectedErrorText;
      TextView unexpectedErrorText = ViewBindings.findChildViewById(rootView, id);
      if (unexpectedErrorText == null) {
        break missingId;
      }

      return new FragmentCatalogBinding((LinearLayout) rootView, catalogErrorScreen,
          catalogProgressBar, catalogRecyclerView, catalogToolbar, catalogViewFlipper,
          refreshButton, unexpectedErrorDetailed, unexpectedErrorText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
