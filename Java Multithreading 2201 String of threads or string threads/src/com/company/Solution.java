package com.company;

/*
2201 String of threads or string threads. That's the question
1. The getPartOfString method should return a substring between the first and last tabs.
2. GetPartOfString should throw an exception on incorrect data:
a) TooShortStringFirstThreadException, if the name of the trade is FIRST_THREAD_NAME.
b) TooShortStringSecondThreadException if the trade name is SECOND_THREAD_NAME.
c) RuntimeException in other cases.
3. Implement the logic of the three protected methods in ThisUncaughtExceptionHandler using the calls of the corresponding methods according to the following patterns:
a) 1 #: TooShortStringFirstThreadException: java.lang.StringIndexOutOfBoundsException: String index out of range: -1
b) java.lang.StringIndexOutOfBoundsException: String index out of range: -1: TooShortStringSecondThreadException: 2 #
c) RuntimeException: java.lang.StringIndexOutOfBoundsException: String index out of range: -1: 3 #

Requirements:
1. The getPartOfString method should return a substring between the first and last tabs of the string string passed to it as the first parameter.
2. In case of incorrect data, the getPartOfString method should throw a TooShortStringFirstThreadException exception if the name of the thread (threadName) is Solution.FIRST_THREAD_NAME.
3. In case of incorrect data, the getPartOfString method should throw a TooShortStringSecondThreadException exception if the name of the thread (threadName) is Solution.SECOND_THREAD_NAME.
4. In case of incorrect data, the getPartOfString method should throw a RuntimeException if the thread name (threadName) is not Solution.FIRST_THREAD_NAME or Solution.SECOND_THREAD_NAME.
5. The getFormattedStringForFirstThread method should return a string formed from the passed parameters according to the template specified in the task.
6. The getFormattedStringForSecondThread method should return a string formed from the passed parameters according to the template specified in the task.
7. The getFormattedStringForOtherThread method should return a string formed from the passed parameters according to the template specified in the task.


public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new ThisUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {
        if (string == null) throw new RuntimeException();
        String result;
        try {
            result = string.substring(string.indexOf("\t") + 1, string.lastIndexOf("\t"));
        }catch (StringIndexOutOfBoundsException e) {
            if (threadName.equals(FIRST_THREAD_NAME)) throw new TooShortStringFirstThreadException(e);
            if (threadName.equals(SECOND_THREAD_NAME)) throw new TooShortStringSecondThreadException(e);
            throw new RuntimeException(e);
        }
        return result;
    }
}



class ThisUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else
        if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForSecondThread(t, e, string));
        } else {
            System.out.println(getFormattedStringForOtherThread(t, e, string));
        }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        return String.format(string, e.getClass().getSimpleName(), e.getCause(), t.getName());
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        return String.format(string, e.getCause(), e.getClass().getSimpleName(), t.getName());
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        return String.format(string,t.getName(), e.getClass().getSimpleName(), e.getCause());
    }
}


class TooShortStringFirstThreadException extends RuntimeException {
    public TooShortStringFirstThreadException(StringIndexOutOfBoundsException cause) {
        super(cause);
    }
}



class TooShortStringSecondThreadException extends RuntimeException {
    public TooShortStringSecondThreadException(StringIndexOutOfBoundsException cause) {
        super(cause);
    }
}

*/
