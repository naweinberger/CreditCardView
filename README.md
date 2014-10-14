CreditCardView
==============

CreditCardView is a custom Android view for displaying credit card information in a styled and clear way.

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.palindromicstudios/credit-card-view/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.palindromicstudios/credit-card-view)

Clone CreditCardView to use the library and an example application, or pull it from Maven Central by including it in your dependencies.


```
'compile com.palindromicstudios:credit-card-view:1.0.0+'
```


Usage
--------------

You can customize the look of the card in XML like this:
```xml
<CreditCardView
    xmlns:cc="http://schemas.android.com/apk/res-auto"
    android:id="@+id/credit_card_view"
    android:layout_width="300dp"
    android:layout_height="175dp"
    android:background="@android:color/black"
    android:textColor="@android:color/white"
    cc:strokeColor="@android:color/white"
    cc:strokeWidth="1dp" />
```

And you can set the content programmatically:

```java
CreditCardView creditCardView = (CreditCardView) findViewById(R.id.credit_card_view);
```

```java
creditCardView.setName("John Doe"); 
creditCardView.setNumber("4242 4242 4242 4242"); //Only displays last four digits
creditCardView.setExpiration("11/2017"); 
```

Setting the card number will only display the last four digits of the number for security reasons. See below for an example.

Example
--------------

![Screenshot](https://raw.github.com/naweinberger/CreditCardView/master/images/screenshot.png)

License
--------------

    Copyright 2014 Natan Weinberger

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
