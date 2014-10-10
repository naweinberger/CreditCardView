/*
    Licensed to the Apache Software Foundation (ASF) under one
    or more contributor license agreements.  See the NOTICE file
    distributed with this work for additional information
    regarding copyright ownership.  The ASF licenses this file
    to you under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.
*/

package com.palindromicstudios.creditcardview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CreditCardView extends RelativeLayout {

    TextView name, number, expiration;
    RelativeLayout backgroundLayout;
    private static final String HTML_BULLETPOINT = "&#8226;";

    public CreditCardView(Context context) {
        this(context, null);
    }

    public CreditCardView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.credit_card, this, true);

        backgroundLayout = (RelativeLayout) findViewById(R.id.credit_card_view_background);
        name = (TextView) findViewById(R.id.card_name);
        number = (TextView) findViewById(R.id.card_number);
        expiration = (TextView) findViewById(R.id.card_expiration);

        //Get styling attributes
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CreditCardView,
                0, 0);

        int black = Color.argb(255, 0, 0, 0);

        //Apply styling attributes
        try {
            this.setBackgroundResource(Color.alpha(0));
            ((GradientDrawable)backgroundLayout.getBackground()).setColor(a.getColor(R.styleable.CreditCardView_android_background, Color.argb(255, 255, 255, 255)));
            ((GradientDrawable)backgroundLayout.getBackground()).setStroke((int)a.getDimension(R.styleable.CreditCardView_strokeWidth, 2), a.getColor(R.styleable.CreditCardView_strokeColor, black));
            name.setTextColor(a.getColor(R.styleable.CreditCardView_android_textColor, black));
            number.setTextColor(a.getColor(R.styleable.CreditCardView_android_textColor, black));
            expiration.setTextColor(a.getColor(R.styleable.CreditCardView_android_textColor, black));
        } finally {
            a.recycle();
        }





    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setNumber(String number) {

        //Must treat "bullets" for blocking card number as HTML to display correctly
        String bullets = "";

        for (int i = 0; i < 3; i ++) {
            bullets += HTML_BULLETPOINT + HTML_BULLETPOINT + HTML_BULLETPOINT + HTML_BULLETPOINT + " ";
        }

        //Last 4 digits
        String newNumber = Html.fromHtml(bullets) + number.substring(number.length()-4, number.length());
        this.number.setText(newNumber);
    }

    public void setExpiration(String date) {
        this.expiration.setText(date);
    }
}
