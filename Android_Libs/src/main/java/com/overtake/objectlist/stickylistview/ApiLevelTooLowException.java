package com.overtake.objectlist.stickylistview;

public class ApiLevelTooLowException extends RuntimeException {

    private static final long serialVersionUID = -5480068364264456757L;

    public ApiLevelTooLowException(int versionCode) {
        super("Requires API level " + versionCode);
    }

}
