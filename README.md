# Hashtagify-Android

<div align="left">
  Built with ❤︎ by
  <a href="https://twoiq.com">Twoiq</a>
</div>
<br/>

Highlight hashtags in EditText and TextInputEditText as text change.

![](https://github.com/twoiq/Hashtagify-android/blob/dev-mufaddal/example.gif)

## 💻 Installation
Add this in your app's build.gradle file:
```groovy
dependencies {
  implementation 'com.twoiq.hashtagify:hashtagify:1.0.0'
}
```

Or add hashtagify as a new dependency inside your pom.xml

```xml
<dependency>
	<groupId>com.twoiq.hashtagify</groupId>
	<artifactId>hashtagify</artifactId>
	<version>1.0.0</version>
	<type>pom</type>
</dependency>
```

## ❔ Usage

##### Use CustomEditText instead of normal EditText to highlight hash tags,
You can use all standard attributes of EditText in CustomEditText
```xml
<com.twoiq.hashtagify.CustomEditText
      android:id="@+id/customEdt"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:layout_margin="16dp"
      android:hint="Enter text with #hashtag"
      android:textSize="18sp"
      android:inputType="textMultiLine"
      android:lines="5"
      android:textColor="@color/colorPrimary"
      app:tagColor="@color/colorAccent"/>
```

##### Use CustomTextInputEditText instead of normal TextInputEditText to highlight hash tags,
You can use all standard attributes of TextInputEditText in CustomTextInputEditText, You can also use it with material TextInputLayout
```xml
<com.twoiq.hashtagify.CustomTextInputEditText
      android:id="@+id/customTiet"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:hint="Enter text with #hashtag"
      android:textSize="18sp"
      android:inputType="textMultiLine"
      android:lines="5"
      android:textColor="@color/colorPrimary"
      app:tagColor="@color/colorAccent"/>
```

##### Use TextView instead of normal TextView to highlight hash tags,
You can use all standard attributes of TextView in CustomTextView
```xml
<com.twoiq.hashtagify.CustomTextView
      android:id="@+id/tvText"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:layout_margin="16dp"
      android:textSize="18sp"
      android:text="Crazy brown #Fox jumps over #Lazy dog"
      android:textColor="@color/colorPrimary"
      app:tagColor="@color/colorAccent"/>
```

## 🎨 Customization and Attributes

You can use all standard attributes of EditText, TextInputLayout, TextView 
<table>
    <th>Attribute Name</th>
    <th>Default Value</th>
    <th>Example Value</th>
    <th>Description</th>
    <tr>
        <td>app:tagColor</td>
        <td>#1e90ff</td>
        <td>@color/colorAccent</td>
        <td>Color of highlighted hashtag for EditText, TextInputLayout, TextView</td>
    </tr>
</table>

## Change hash tag color (Kotlin)
```java
// EditText
edt.setTagColor(ContextCompat.getColor(this, R.color.colorRed))

// TextInputEditText
tiet.setTagColor(ContextCompat.getColor(this, R.color.colorRed))

// TextView
tv.setTagColor(ContextCompat.getColor(this, R.color.colorRed))

```

## 👨 Developed By

```
Mufaddal Makda
```
- Website (https://twoiq.com)

# 👍 How to Contribute
1. Fork it
2. Create your feature branch (git checkout -b my-new-feature)
3. Commit your changes (git commit -am 'Add some feature')
4. Push to the branch (git push origin my-new-feature)
5. Create new Pull Request

# 📃 License

    Copyright 2020 twoiq

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
