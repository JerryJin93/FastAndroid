package com.jerryjin.fastandroid.utility.bean;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import com.jerryjin.fastandroid.ui.utility.IconHelper;

public class InstalledApp implements Parcelable {


    public static final Creator<InstalledApp> CREATOR = new Creator<InstalledApp>() {
        @Override
        public InstalledApp createFromParcel(Parcel in) {
            return new InstalledApp(in);
        }

        @Override
        public InstalledApp[] newArray(int size) {
            return new InstalledApp[size];
        }
    };

    private String packageName;
    private String className;
    private Bitmap icon;
    private String name;

    public InstalledApp() {
        super();
    }


    public InstalledApp(String packageName, String className, Drawable icon, String name) {
        this.packageName = packageName;
        this.className = className;
        this.icon = IconHelper.getIcon(icon);
        this.name = name;
    }

    protected InstalledApp(Parcel in) {
        packageName = in.readString();
        icon = in.readParcelable(Bitmap.class.getClassLoader());
        name = in.readString();
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(packageName);
        dest.writeParcelable(icon, 0);
        dest.writeString(name);
    }
}
