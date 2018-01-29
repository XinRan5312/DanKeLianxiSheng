package com.xinran.studyindanke.reflect;

/**
 * Created by houqixin on 2018/1/29.
 */

public class ReflectException extends RuntimeException {

    /**
     * Generated UID
     *  * <p>
     * These exceptions are
     * <ul>
     * <li> {@link ClassNotFoundException}</li>
     * <li> {@link IllegalAccessException}</li>
     * <li> {@link IllegalArgumentException}</li>
     * <li> {@link InstantiationException}</li>
     * <li> {@link NoSuchMethodException}</li>
     * <li> {@link NoSuchFieldException}</li>
     * <li> {@link SecurityException}</li>
     * </ul>
     */
    private static final long serialVersionUID = -6213149635297151442L;

    public ReflectException(String message) {
        super(message);
    }

    public ReflectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReflectException() {
        super();
    }

    public ReflectException(Throwable cause) {
        super(cause);
    }
}

